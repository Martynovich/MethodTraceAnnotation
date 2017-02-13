package com.andersen;

import org.apache.log4j.*;
import org.apache.log4j.Level;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class TraceAspect {

    private Logger logger = Logger.getLogger(TraceAspect.class);

    @Around("execution(* *(..)) && @annotation(com.andersen.MethodTrace)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        MethodTrace annotation = method.getAnnotation(MethodTrace.class);
        Level logLevel = org.apache.log4j.Level.toLevel(annotation.level().name());
        for (Object object : point.getArgs()) {
            logger.log(logLevel, "Method argument - " + object.toString());
        }
        long startMethod = System.currentTimeMillis();

        Object result = point.proceed();

        logger.log(logLevel, "Method result - " + result.toString());
        logger.log(logLevel, "Method process time - " + (System.currentTimeMillis() - startMethod));
        return  result;
    }
}
