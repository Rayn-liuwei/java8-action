package com.ryan.java8.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/7 13:13.
 */
public class CaffeineTestCase {

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
}
