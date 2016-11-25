package com.ryan.java8.defaultmethod;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 16:14.
 */
public interface Moveable {

    public int getX();

    public int getY();

    /**
     * @param x
     */
    public void setX(int x);

    /**
     * @param y
     */
    public void setY(int y);


    /**
     * 水平移动
     *
     * @param distance
     */
    default void moveHorizontally(int distance) {
        setX(getX() + distance);
    }

    /**
     * 垂直移动
     *
     * @param distance
     */
    default void moveVertically(int distance) {
        setY(getY() + distance);
    }
}
