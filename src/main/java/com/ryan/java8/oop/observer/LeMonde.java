package com.ryan.java8.oop.observer;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:15.
 */
public class LeMonde implements Observer {
    @Override
    public void notify(String news) {
        if (news.contains("wine")) {
            System.err.println("Lemonde 接收到消息。");
        }
    }
}
