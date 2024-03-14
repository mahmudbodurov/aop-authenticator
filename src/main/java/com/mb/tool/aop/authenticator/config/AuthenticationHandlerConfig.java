package com.mb.tool.aop.authenticator.config;


import com.mb.tool.aop.authenticator.AuthenticationHandler;
import com.mb.tool.aop.authenticator.AuthenticationResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationHandlerConfig {

    @Bean
    @ConditionalOnBean(AuthenticationResolver.class)
    public AuthenticationHandler authenticationHandler(AuthenticationResolver authenticationResolver) {
        return new AuthenticationHandler(authenticationResolver);
    }
}
