package com.ryan.java8.defaultmethod;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 16:27.
 */
//public interface HelloB extends HelloA {
public interface HelloB {

    /**
     * 多继承测试
     */
    default void hello() {
        System.err.println("HelloB.hello() method invoke.");
    }
}
