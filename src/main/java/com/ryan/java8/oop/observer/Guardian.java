package com.ryan.java8.oop.observer;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:14.
 */
public class Guardian implements Observer {
    @Override
    public void notify(String news) {
        if (news.contains("queen")) {
            System.err.println("Guardian 接收到消息。");
        }
    }
}
