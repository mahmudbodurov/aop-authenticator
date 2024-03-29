package com.mb.tool.aop.authenticator;


import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;


public interface AuthenticationResolver {
    default Object authenticate(String authorization) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default Object authenticate(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default Object authenticate(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
