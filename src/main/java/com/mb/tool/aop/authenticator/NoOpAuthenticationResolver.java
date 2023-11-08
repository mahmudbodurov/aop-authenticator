package com.mb.tool.aop.authenticator;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;

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
    public Object authenticate(MethodParameter parameter, NativeWebRequest webRequest) {
        return new Object();
    }
}
