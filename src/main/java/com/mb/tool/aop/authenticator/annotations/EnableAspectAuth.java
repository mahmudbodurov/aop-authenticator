package com.mb.tool.aop.authenticator.annotations;

import com.mb.tool.aop.authenticator.config.AuthenticationHandlerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AuthenticationHandlerConfig.class)
public @interface EnableAspectAuth {
}