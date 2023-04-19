package com.mb.tool.aop.authenticator;


public interface AuthenticationResolver {
    Object authenticate(String authorization);
}
