package com.mb.tool.aop.authenticator.config;

import com.mb.tool.aop.authenticator.AuthenticationResolver;
import com.mb.tool.aop.authenticator.AuthenticationUserMethodHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class EnableCustomRequestParamMethodConfig {
    @Bean
    @ConditionalOnMissingBean(CustomRequestParamMethodArgumentResolver.class)
    @ConditionalOnBean(AuthenticationResolver.class)
    public CustomRequestParamMethodArgumentResolver customRequestParamMethodArgumentResolver(@Lazy AuthenticationResolver authenticationResolver) {
        return new CustomRequestParamMethodArgumentResolver(new AuthenticationUserMethodHandler(authenticationResolver));
    }
}