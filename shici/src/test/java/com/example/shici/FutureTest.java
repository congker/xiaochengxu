/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici;

import java.util.Random;
import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        futureMehtod1();
        futureMehtod2();
    }

    /**
     * 异步方法1
     */
    static void futureMehtod1() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        executor.shutdown();

        try {
            System.out.println("result:" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static void futureMehtod2() {
        //第一种方式
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        new Thread(task).start();
        try {
            System.out.println("result: " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static void futureMehtod3() {
        //第二种方方式
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        executor.submit(task);
        try {
            System.out.println("result: " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
