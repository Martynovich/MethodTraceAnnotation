package com.andersen;

import net.sf.cglib.proxy.MethodInterceptor;import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import java.lang.reflect.Method;

class TraceInvocationHandler implements MethodInterceptor {

    private Logger logger = Logger.getLogger(TraceInvocationHandler.class);

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (!method.isAnnotationPresent(MethodTrace.class)) {
            return methodProxy.invokeSuper(o, objects);
        }
        MethodTrace annotation = method.getAnnotation(MethodTrace.class);
        Level logLevel = org.apache.log4j.Level.toLevel(annotation.level().name());
        for (Object object : objects) {
            logger.log(logLevel, "Method argument - " + object.toString());
        }
        long startInvoke = System.currentTimeMillis();
        Object invokeResult = methodProxy.invokeSuper(o, objects);
        logger.log(logLevel, "Method result - " + invokeResult.toString());
        logger.log(logLevel, "Method lead time - " + (System.currentTimeMillis() - startInvoke));
        return invokeResult;
    }
}
