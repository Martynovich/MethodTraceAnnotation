package com.andersen;

class AnnotatedClass {

    @MethodTrace(level = Level.DEBUG)
    public String annotatedMethod(String string, int num) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return string + num;
    }
}
