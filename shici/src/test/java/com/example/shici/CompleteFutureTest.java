/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteFutureTest {
    public static void main(String[] args) throws Exception {
        CompleteFutureMethod0();
//        CompleteFutureMethod();
//        CompleteFutureMethod1();
    }

    /**
     * 完成
     */
    static void CompleteFutureMethod0() throws Exception {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Finish Task ";
        });

        try {
            System.out.println("future:" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future1 = future.thenApplyAsync(v -> {
            return v + "world";
        });

        String result = future1.join();
        System.out.println(result);
    }

    /**
     * 完成
     */
    static void CompleteFutureMethod() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi Boy";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi Girl";
        }), (s) -> {
            System.out.println("s value:" + s);
            return s;
        }).join();
        System.out.println(result);
    }

    /**
     * 完成
     */
    static void CompleteFutureMethod1() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true) {
                throw new RuntimeException("exception test!");
            }

            return "Hi Boy";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "Hello world!";
        }).join();
        System.out.println(result);
    }
}
