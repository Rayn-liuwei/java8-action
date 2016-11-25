package com.ryan.java8.oop.strategy;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:00.
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 验证
     *
     * @param s
     * @return
     */
    public boolean validate(String s) {
        return strategy.execute(s);
    }
}
