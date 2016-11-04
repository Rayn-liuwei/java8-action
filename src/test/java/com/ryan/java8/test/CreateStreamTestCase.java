package com.ryan.java8.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建流
 *
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/4 17:22.
 */
public class CreateStreamTestCase {

    public static final Logger LOG = LoggerFactory.getLogger(CreateStreamTestCase.class);


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * 创建流
     *
     * @throws Exception
     */
    @Test
    public void testCreateStream() throws Exception {
        //由值创建流
        Stream<String> stringStream = Stream.of("java8", "Lambdas", "In", "Action");
        Stream<Object> empty = Stream.empty();

        //由数组创建流
        int sum = Arrays.stream(new int[]{1, 2, 3, 5}).sum();

        //由文件创建流
        Stream<String> lines = Files.lines(Paths.get("src/main/resources", "data.txt"), Charset.defaultCharset());
        long count = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        LOG.info("总数为: {}", count);


        //由函数来创建
        //创建无限流
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        //随机数生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        IntStream.generate(() -> 1).forEach(System.out::println);

        IntStream.generate(new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        }).limit(10).forEach(System.out::println);



    }
}