package com.example.demo;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
public class DemoAspect {

    @Before(value = "execution(* com.example.demo..*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Implement Before Advice");
    }

    @After(value = "execution(* com.example.demo..*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("Implement After Advice");
    }

    @AfterReturning(value = "execution(* com.example.demo..*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint) {
        System.out.println("Implement After Returning Advice");
    }

    @Around(value = "execution(* com.example.demo..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("Implement Around Advice");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println(e);
        }
    }

}
