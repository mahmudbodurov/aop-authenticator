package com.mb.tool.aop.authenticator.annotations;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthenticationRequired {
    String authHeader() default "Authorization";
}
