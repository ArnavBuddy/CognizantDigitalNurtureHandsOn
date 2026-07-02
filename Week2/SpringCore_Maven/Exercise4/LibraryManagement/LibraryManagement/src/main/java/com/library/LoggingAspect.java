package com.library;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Cross-cutting logging aspect that demonstrates Spring AOP.
 * Advises every method call made on LibraryService.
 */
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.LibraryService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP] Intercepted call to: " + joinPoint.getSignature().getName());
    }
}
