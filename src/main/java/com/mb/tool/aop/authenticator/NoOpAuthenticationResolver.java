package com.mb.tool.aop.authenticator;

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
}
