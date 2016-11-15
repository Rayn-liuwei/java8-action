package com.ryan.java8.stream.parrallel;

import com.ryan.java8.entity.WordCount;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/15 18:21.
 */
public class StreamExample {

    /**
     * @param n
     * @return
     */
    public static long rangeSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    /**
     * @param n
     * @return
     */
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }

    /**
     * 顺序流
     *
     * @param n
     * @return
     */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    /**
     * 并行流
     *
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        //将并行转换为顺序流
        Stream.iterate(1L, i -> i + 1).limit(n).parallel().sequential();

        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    /**
     * 统计字符个数
     *
     * @param str
     * @return
     */
    public static final String SENTENCE = "abcdefghijk lmnthis is a test wordcount, found work sum charactor.";

    /**
     * 统计字符个数
     *
     * @return
     */
    public static int sumWork() {

        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        WordCount wordCounter = characterStream.reduce(new WordCount(0, true), WordCount::accumulater, WordCount::combine);

        return wordCounter.getCounter();
    }


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        rangeSum(1_000_000);

        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        parallelRangedSum(1_000_000);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));

        int sumCharacter = sumWork();
        System.out.println("总字符数: " + sumCharacter);

    }


}
