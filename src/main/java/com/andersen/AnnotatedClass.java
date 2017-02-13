package com.andersen;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AnnotatedClass {

    private Logger logger = Logger.getLogger(AnnotatedClass.class);

    @MethodTrace(level = Level.ERROR)
    public String annotatedMethod(String string, int num) {
        return "I am annotated method. Result - " + string + " " + num;
    }

    public void notAnnotatedMethod(int i, String s) {
        logger.info("Hello, I am not annotated method - " + i + " " + s);
    }
}
