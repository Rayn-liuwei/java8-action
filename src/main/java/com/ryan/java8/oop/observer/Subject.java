package com.ryan.java8.oop.observer;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:16.
 */
public interface Subject {

    /**
     * 注册观察者
     * @param o
     */
    public void registerObserver(Observer o);

    /**
     * 通知观察者
     * @param news
     */
    public void notifyObservers(String news);
}
