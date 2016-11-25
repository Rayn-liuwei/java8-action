package com.ryan.java8.defaultmethod;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 16:04.
 */
public interface Sized {

    /**
     *
     * @return
     */
    public int size();

    /**
     * @return
     */
    default boolean isEmpty() {
        System.err.println("执行接口中的 default 方法。");
        System.err.println("获取执行 size() 方法的结果 ：" + size());

        return false;
    }
}
