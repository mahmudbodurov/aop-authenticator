package com.mb.tool.aop.authenticator;


import javax.servlet.http.HttpServletRequest;

public interface AuthenticationResolver {
    Object authenticate(String authorization);

    Object authenticate(HttpServletRequest request);
}
