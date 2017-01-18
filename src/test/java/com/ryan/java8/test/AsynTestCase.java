package com.ryan.java8.test;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2017/1/18 11:47.
 */
public class AsynTestCase extends Data {
    private static final Logger LOG = LoggerFactory.getLogger(AsynTestCase.class);


    @After
    public void tearDown() throws Exception {

    }

    /**
     * 使用 CompletableFuture 发起异步请求
     *
     * @throws Exception
     */
    @Test
    public void testCompletableFuture() throws Exception {

        Stream<CompletableFuture<String>> futureStream = strList.stream().map(s -> CompletableFuture.supplyAsync(() -> s + "##"));
        List<CompletableFuture<String>> collect = futureStream.collect(Collectors.toList());

        /**
         * 等待所有异步操作结束
         */
        List<String> result = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        for (String s : result) {
            System.err.println("s = " + s);
        }


    }
}
