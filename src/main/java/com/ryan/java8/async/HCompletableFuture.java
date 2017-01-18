package com.ryan.java8.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2017/1/18 11:39.
 */
public class HCompletableFuture {

    /**
     * 异步获取结果
     *
     * @param product
     * @return
     */
    public Future<String> getPriceAsync(String product) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        new Thread(new Runnable() {
            @Override
            public void run() {

                /**
                 * 执行一个耗时的操作
                 */
                try {
                    System.err.println("睡眠5s，模拟正在计算。");
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                completableFuture.complete("123");
            }
        }).start();

        return completableFuture;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HCompletableFuture hCompletableFuture = new HCompletableFuture();
        Future<String> priceAsync = hCompletableFuture.getPriceAsync("123123123");
        Future<String> priceAsync1 = hCompletableFuture.getPriceAsync("345345");

        System.err.println("Result : " + priceAsync.get());
        System.err.println("Result : " + priceAsync1.get());

    }
}
