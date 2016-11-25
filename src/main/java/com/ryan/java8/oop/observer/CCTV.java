package com.ryan.java8.oop.observer;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:13.
 */
public class CCTV implements Observer {

    /**
     *
     * @param news
     */
    @Override
    public void notify(String news) {
        if(news.contains("cctv")){
            System.err.println("CCTV 接收到消息。");
        }
    }
}
