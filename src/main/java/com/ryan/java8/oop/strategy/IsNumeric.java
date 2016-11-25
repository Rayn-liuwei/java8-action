package com.ryan.java8.oop.strategy;

/**
 * 
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 13:58.
 */
public class IsNumeric implements ValidationStrategy {


    /**
     * 是否都是数据
     * @param s
     * @return
     */
    @Override
    public boolean execute(String s) {

        return s.matches("\\d+");
    }
}
