package com.youxianqin.dockermgr.shiro.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youxianqin.dockermgr.util.ResponseData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyPermissionsAuthorizationFilter extends AccessControlFilter {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        ResponseData responseData = new ResponseData();
        Subject subject = getSubject(request, response);
        // If the subject isn't identified, redirect to login URL
        if (subject.getPrincipal() == null) {
            responseData.setStatus(false);
            responseData.setInfo("未登录");
            responseOutWithJson(response,responseData,401);
        } else {
            // If subject is known but not authorized, redirect to the unauthorized URL if there is one
            responseData.setStatus(false);
            responseData.setInfo("权限不足");
            responseOutWithJson(response,responseData,403);
        }
        return false;
    }

    @Override
    protected   String getPathWithinApplication(ServletRequest request) {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        String contextPath = WebUtils.getContextPath(httpRequest);
        String method = httpRequest.getMethod();
        String requestUri = WebUtils.getRequestUri(httpRequest);
        StringBuilder urlSb = new StringBuilder();
        urlSb.append(method).append(" ");
        if (StringUtils.startsWithIgnoreCase(requestUri, contextPath)) {
            String path = requestUri.substring(contextPath.length());
            if (StringUtils.hasText(path)) {
                urlSb.append(path);
            } else {
                urlSb.append("/");
            }
        } else {
            urlSb.append(requestUri);
        }
        return urlSb.toString();
    }

    @Override
    protected boolean pathsMatch(String pattern, String path) {
        LOGGER.info(pattern);
        LOGGER.info(path);
        return this.pathMatcher.matches(pattern, path);
    }

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = this.getSubject(request, response);
        String[] perms = (String[])((String[])mappedValue);
        LOGGER.info(perms);
        boolean isPermitted = true;
        if (perms != null && perms.length > 0) {
            if (perms.length == 1) {
                if (!subject.isPermitted(perms[0])) {
                    isPermitted = false;
                }
            } else if (!subject.isPermittedAll(perms)) {
                isPermitted = false;
            }
        }

        return isPermitted;
    }
    private void responseOutWithJson(ServletResponse response, ResponseData responseData,int httpCode) throws IOException{
        ObjectMapper om = new ObjectMapper();
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String resultStr = om.writeValueAsString(responseData);
        response.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(httpCode);
        httpResponse.getWriter().append(resultStr).flush();
    }
}
