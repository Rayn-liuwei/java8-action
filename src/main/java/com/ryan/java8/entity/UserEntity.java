package com.ryan.java8.entity;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/4 13:45.
 */
public class UserEntity {
    private long uid;

    private String username;

    private int sex;

    public UserEntity() {
    }

    public UserEntity(int sex, long uid, String username) {
        this.sex = sex;
        this.uid = uid;
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
