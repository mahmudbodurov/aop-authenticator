package com.mb.tool.aop.authenticator;


import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationResolver {
    Object authenticate(String authorization);

    Object authenticate(HttpServletRequest request);

    Object authenticate(MethodParameter parameter, NativeWebRequest webRequest) throws Exception;
}
