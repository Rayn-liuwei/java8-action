package com.ryan.java8.oop.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:17.
 */
public class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();


    /**
     * 注册观察者
     *
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {

        this.observers.add(o);

    }

    /**
     * 通知观察者
     *
     * @param news
     */
    @Override
    public void notifyObservers(String news) {
        observers.forEach(o -> o.notify(news));
    }
}
