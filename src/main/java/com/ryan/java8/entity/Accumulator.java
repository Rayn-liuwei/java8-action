package com.ryan.java8.entity;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/15 18:37.
 */
public class Accumulator {

    public long total = 0;

    public void add(long value) {
        total += value;
    }
}
