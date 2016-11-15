package com.ryan.java8.stream.parrallel;

import com.ryan.java8.entity.Accumulator;

import java.util.stream.LongStream;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/15 18:27.
 */
public class AccumulatorExample {

    /**
     * 共享累加器
     *
     * @param n
     * @return
     */
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();

        LongStream.rangeClosed(1, n).forEach(accumulator::add);

        return accumulator.total;
    }

    /**
     * 使用并行流方式
     *
     * @param n
     * @return
     */
    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();

        /**
         * forEarch 为非原子性，数据计算有错误
         */
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);

        return accumulator.total;
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long total1 = sideEffectSum(1_000_000);

        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + ", total : " + total1);

        startTime = System.currentTimeMillis();
        long total2 = sideEffectParallelSum(1_000_000);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + " , total : " + total2);
    }
}
