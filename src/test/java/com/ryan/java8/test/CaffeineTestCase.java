package com.ryan.java8.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/7 13:13.
 */
public class CaffeineTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(CaffeineTestCase.class);

    /**
     *
     * @throws Exception
     */
    @Test
    public void testCaffeine() throws Exception {

        Cache<Object, Object> cache = Caffeine.newBuilder().maximumSize(10_000)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .refreshAfterWrite(1, TimeUnit.MINUTES)
                .build();

    }

    /**
     * 位计算测试
     * @throws Exception
     */
    @Test
    public void testBitCompute() throws Exception {
        Integer a = 100;
        Integer b = 100;

        Integer c = 1000;
        Integer d = 1000;

        System.out.println(a == b);
        System.out.println(c == d);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        LOG.info("a = {} : b = {} ", a, b);

        LOG.info("a ^ b = {}", a ^ b);
        LOG.info("(a ^ b ) ^ a = {}", (a ^ b) ^ a);

    }
}
