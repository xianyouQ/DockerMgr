package com.youxianqin.dockermgr.shiro.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youxianqin.dockermgr.util.ResponseData;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

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

    private void responseOutWithJson(ServletResponse response, ResponseData responseData,int httpCode) throws IOException{
        ObjectMapper om = new ObjectMapper();
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String resultStr = om.writeValueAsString(responseData);
        response.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(httpCode);
        httpResponse.getWriter().append(resultStr).flush();
    }
}
