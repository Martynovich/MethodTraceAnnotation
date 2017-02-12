package com.andersen;

import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

    private static Logger logger = Logger.getLogger(TestClass.class);

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        classInspector("com.andersen.AnnotatedClass", "Igor", 27);
    }

    static void classInspector(String className, String string, int num) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodTrace.class)) {
                Object object = clazz.newInstance();
                Annotation annotation = method.getAnnotation(MethodTrace.class);
                long start = System.currentTimeMillis();

                String s = (String) method.invoke(object, string, num);
                System.out.println(s);
//                System.out.println(annotation + object.toString());
            }
        }

    }
}
