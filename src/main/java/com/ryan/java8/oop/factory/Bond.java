package com.ryan.java8.oop.factory;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:41.
 */
public class Bond implements Product{
    /**
     * 生成产品
     */
    @Override
    public void processing() {
        System.out.println("我生成 Bond.");
    }
}
