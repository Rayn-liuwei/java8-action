package com.ryan.java8.oop.chain.responsibility;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:29.
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    /**
     * 执行工作
     *
     * @param input
     * @return
     */
    @Override
    public String handleWork(String input) {

        return "I'm From HeaderTextProcessing class HandleWork method.";
    }
}
