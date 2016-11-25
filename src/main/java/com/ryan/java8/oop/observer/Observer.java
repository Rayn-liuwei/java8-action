package com.ryan.java8.oop.observer;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:12.
 */
public interface Observer {

    /**
     * 通知
     *
     * @param news
     */
    public void notify(String news);
}
