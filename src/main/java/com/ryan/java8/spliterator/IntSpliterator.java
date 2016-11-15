package com.ryan.java8.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 可分迭代器
 *
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/15 19:05.
 */
public class IntSpliterator implements Spliterator<Integer> {


    @Override
    public boolean tryAdvance(Consumer<? super Integer> action) {
        return false;
    }


    /**
     *
     * @return
     */
    @Override
    public Spliterator<Integer> trySplit() {


        return null;
    }


    /**
     * 估算剩余元素个数
     *
     * @return
     */
    @Override
    public long estimateSize() {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public int characteristics() {
        return 0;
    }
}
