package com.ryan.java8.defaultmethod;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 16:29.
 */
public class HelloImpl implements HelloA, HelloB {


    /**
     * 多继承测试
     */
    @Override
    public void hello() {
        HelloA.super.hello();
    }
}
