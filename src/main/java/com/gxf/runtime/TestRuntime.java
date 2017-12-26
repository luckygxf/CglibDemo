package com.gxf.runtime;

import java.io.IOException;

/**
 * Created by 58 on 2017/12/26.
 */
public class TestRuntime {

    public static void main(String[] args) {
        execCMD();
    }

    private static void execCMD(){
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("notepad");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addHooks(){
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new FirstHook());
        runtime.addShutdownHook(new SecodeHook());
        runtime.exit(1);
    }

    private static void runtimeMethod(){
        Runtime runtime = Runtime.getRuntime();
        System.out.println("runtime.freeMemory(): " + runtime.freeMemory() / 1024 / 1024 + "MB");
        System.out.println("runtime.maxMemory(): " + runtime.maxMemory() / 1024 / 1024 + "MB");
        System.out.println("runtime.totalMemory(): " + runtime.totalMemory() / 1024 / 1024 + "MB");
    }

    static class FirstHook extends Thread{
        public void run(){
            System.out.println("First hook exec.");
        }
    }

    static class SecodeHook extends Thread{
        public void run(){
            System.out.println("Second hook exec.");
        }
    }
}
