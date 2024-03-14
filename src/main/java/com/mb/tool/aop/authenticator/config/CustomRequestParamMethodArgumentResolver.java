package com.mb.tool.aop.authenticator.config;

import com.mb.tool.aop.authenticator.AuthenticationUserMethodHandler;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class CustomRequestParamMethodArgumentResolver implements WebMvcConfigurer {


    private final AuthenticationUserMethodHandler resolver;

    public CustomRequestParamMethodArgumentResolver(AuthenticationUserMethodHandler resolver) {
        this.resolver = resolver;
    }


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(resolver);
    }
}