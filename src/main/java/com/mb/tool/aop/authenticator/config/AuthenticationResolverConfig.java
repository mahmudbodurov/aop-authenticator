package com.mb.tool.aop.authenticator.config;


import com.mb.tool.aop.authenticator.AuthenticationHandler;
import com.mb.tool.aop.authenticator.AuthenticationResolver;
import com.mb.tool.aop.authenticator.NoOpAuthenticationResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(AuthenticationHandler.class)
public class AuthenticationResolverConfig {

    @Bean
    @ConditionalOnMissingBean(AuthenticationResolver.class)
    public AuthenticationResolver authenticationResolver() {
        return new NoOpAuthenticationResolver();
    }

    @Bean
    @ConditionalOnMissingBean()
    public AuthenticationHandler authenticationHandler(AuthenticationResolver authenticationResolver) {
        return new AuthenticationHandler(authenticationResolver);
    }

}
