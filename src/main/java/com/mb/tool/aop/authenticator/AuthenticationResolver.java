package com.mb.tool.aop.authenticator;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;


public interface AuthenticationResolver {
    default Object authenticate(String authorization) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default Object authenticate(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default Object authenticate(MethodParameter parameter, NativeWebRequest webRequest) throws Exception {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
