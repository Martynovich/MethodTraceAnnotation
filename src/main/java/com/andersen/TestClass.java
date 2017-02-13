package com.andersen;

import net.sf.cglib.proxy.Enhancer;
import org.apache.log4j.*;

public class TestClass {

    private static Logger logger = Logger.getLogger(TestClass.class);

    public static void main(String[] args) {
        logger.info("Start application.");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AnnotatedClass.class);
        enhancer.setCallback(new TraceInvocationHandler());
        AnnotatedClass annotatedClass = (AnnotatedClass) enhancer.create();
        annotatedClass.annotatedMethod("Igor", 27);
        annotatedClass.notAnnotetedMethod(27, "Igor");
    }
}
