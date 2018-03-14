package com.youxianqin.dockermgr.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@RestControllerAdvice
public class MyExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    @ExceptionHandler(Exception.class)
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) {
        LOGGER.error("exception catch",e);
        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        mv.setView(view);
        mv.addObject("status", false);
        mv.addObject("info", e.getMessage());
        mv.addObject("data","");
        return mv;
    }
}
