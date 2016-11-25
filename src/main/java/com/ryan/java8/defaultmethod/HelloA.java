package com.ryan.java8.defaultmethod;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 16:27.
 */
public interface HelloA {

    /**
     * 多继承测试
     */
    default void hello() {
        System.err.println("HelloA.hello() method invoke.");
    }
}
