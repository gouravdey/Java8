package com.gd.lambda;

public class RunnableLambdaExample {

    public static void main(String[] args) {
        /**
         * Legacy Style Example
         */

        Runnable runnableLegacy1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnableLegacy1");
            }
        };

        new Thread(runnableLegacy1).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnableLegacy2");
            }
        }).start();

        /**
         * Modern Style Example
         */

        Runnable runnableModern1 = () -> {
            System.out.println("Inside runnableModern1");
        };

        Runnable runnableModern2 = () -> System.out.println("Inside runnableModern2");

        new Thread(runnableModern1).start();
        new Thread(runnableModern2).start();
        new Thread(() -> System.out.println("Inside runnableModern3")).start();
    }

}
