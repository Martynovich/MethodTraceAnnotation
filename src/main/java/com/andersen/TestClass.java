package com.andersen;

import net.sf.cglib.proxy.Enhancer;
import org.apache.log4j.*;
import org.apache.log4j.Level;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

    private static Logger logger = Logger.getLogger(TestClass.class);

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AnnotatedClass.class);
        enhancer.setCallback(new TraceInvocationHandler());
        AnnotatedClass annotatedClass = (AnnotatedClass) enhancer.create();
        annotatedClass.annotatedMethod("Igor", 27);
        annotatedClass.notAnnotetedMethod(27, "Igor");
    }
}
