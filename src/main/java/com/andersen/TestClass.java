package com.andersen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {

    public static void main(String[] args) {
//        logger.info("Start application.");
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(AnnotatedClass.class);
//        enhancer.setCallback(new TraceInvocationHandler());
//        AnnotatedClass annotatedClass = (AnnotatedClass) enhancer.create();
//        annotatedClass.annotatedMethod("Igor", 27);
//        annotatedClass.notAnnotatedMethod(27, "Igor");
        ApplicationContext context = new AnnotationConfigApplicationContext(TraceApplication.class);
        AnnotatedClass annotatedClass = (AnnotatedClass) context.getBean("annotatedClass");
        annotatedClass.annotatedMethod("Igor", 27);
        annotatedClass.notAnnotatedMethod(27, "Igor");
    }
}
