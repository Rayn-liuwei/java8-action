package com.ryan.java8.stream.parrallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/15 18:45.
 */
public class ForkJoinSum extends RecursiveTask<Long> {

    private static final long THRESHOLD = 10_000;
    private final long[] numbers;
    private final int start;
    private final int end;

    private ForkJoinSum(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSum(long[] numbers, int start, int end) {
        this.end = end;
        this.numbers = numbers;
        this.start = start;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkJoinSum leftTask = new ForkJoinSum(numbers, start, start + length / 2);
        leftTask.fork();

        ForkJoinSum rightTask = new ForkJoinSum(numbers, start + length / 2, end);
        rightTask.fork();

        Long rightReuslt = rightTask.compute();
        Long leftReuslt = leftTask.compute();

        return rightReuslt + leftReuslt;
    }

    /**
     * 执行顺序计算
     *
     * @return
     */
    public long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        long [] numbers = LongStream.rangeClosed(1, 1_000_000).toArray();

        ForkJoinTask<Long> task = new ForkJoinSum(numbers);
        Long result = new ForkJoinPool().invoke(task);
        System.out.println("执行结果: " + result);


    }


}
