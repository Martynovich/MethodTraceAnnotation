package com.andersen;

class AnnotatedClass {

    @MethodTrace(level = Level.INFO)
    public String annotatedMethod(String string, int num) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I am annotated method. Result - " + string + " " + num;
    }

    public void notAnnotetedMethod(int i, String s) {
        System.out.println("Hello, I am not annotated method.");
    }
}
