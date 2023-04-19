package com.mb.tool.aop.authenticator;

public class NoOpAuthenticationResolver implements AuthenticationResolver {
    @Override
    public Object authenticate(String authorization) {
        return authorization;
    }
}
