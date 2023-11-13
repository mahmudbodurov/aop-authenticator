package com.mb.tool.aop.authenticator;

import com.mb.tool.aop.authenticator.annotations.AuthenticationRequired;
import com.mb.tool.aop.authenticator.annotations.AuthenticationUser;
import com.mb.tool.aop.authenticator.enums.AuthenticationType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Parameter;


@Aspect
@RequiredArgsConstructor
public class AuthenticationHandler {
    private final AuthenticationResolver authenticationResolver;

    @Pointcut("@annotation(authenticationRequired)")
    public void callAt(AuthenticationRequired authenticationRequired) {
    }

    @Around(value = "callAt(authenticationRequired)", argNames = "proceedingJoinPoint,authenticationRequired")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, AuthenticationRequired authenticationRequired) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        var signature = ((MethodSignature) proceedingJoinPoint.getSignature());
        Object[] args = proceedingJoinPoint.getArgs();
        Parameter[] parameters = signature.getMethod().getParameters();
        Object object;
        if (authenticationRequired.type() == AuthenticationType.AUTHORIZATION) {
            String authHeader = request.getHeader(authenticationRequired.authHeader());
            object = authenticationResolver.authenticate(authHeader);
        } else {
            object = authenticationResolver.authenticate(request);
        }
        setUserToMethod(parameters, args, object);
        return proceedingJoinPoint.proceed(args);
    }

    private void setUserToMethod(Parameter[] parameters, Object[] args, Object user) {
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].isAnnotationPresent(AuthenticationUser.class)) {
                args[i] = user;
            }
        }
    }
}
