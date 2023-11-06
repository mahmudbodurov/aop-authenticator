package com.mb.tool.aop.authenticator.annotations;

import com.mb.tool.aop.authenticator.enums.AuthenticationType;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthenticationRequired {
    String authHeader() default "Authorization";

    AuthenticationType type() default AuthenticationType.AUTHORIZATION;
}
