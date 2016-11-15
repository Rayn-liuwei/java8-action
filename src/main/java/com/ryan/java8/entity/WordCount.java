package com.ryan.java8.entity;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/15 19:28.
 */
public class WordCount {
    private final int counter;
    private final boolean lastSpace;

    public WordCount(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCount accumulater(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCount(counter, true);
        } else {
            return lastSpace ? new WordCount(counter + 1, false) : this;
        }
    }

    /**
     * 合并结果
     *
     * @param wordCounter
     * @return
     */
    public WordCount combine(WordCount wordCounter) {
        return new WordCount(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}
