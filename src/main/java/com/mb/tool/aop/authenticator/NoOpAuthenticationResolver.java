package com.mb.tool.aop.authenticator;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;


public class NoOpAuthenticationResolver implements AuthenticationResolver {
    @Override
    public Object authenticate(String authorization) {
        return authorization;
    }

    @Override
    public Object authenticate(HttpServletRequest request) {
        return new Object();
    }

    @Override
    public Object authenticate(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        return new Object();
    }
}
