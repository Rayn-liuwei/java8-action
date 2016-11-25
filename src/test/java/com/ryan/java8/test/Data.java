package com.ryan.java8.test;

import com.ryan.java8.entity.UserEntity;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 11:45.
 */
public class Data {

    protected List<String> strList = new ArrayList<String>();
    protected List<Integer> intList = new ArrayList<Integer>();
    protected List<UserEntity> users = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        strList.add("one");
        strList.add("two");
        strList.add("three");
        strList.add("four");
        strList.add("five");

        intList.add(1);
        intList.add(4);
        intList.add(2);
        intList.add(3);
        intList.add(6);
        intList.add(9);
        intList.add(8);
        intList.add(7);


        users = Arrays.asList(new UserEntity(1, 11L, "testtest1"),
                new UserEntity(2, 22L, "testtest2"),
                new UserEntity(3, 33L, "testtest3"),
                new UserEntity(4, 44L, "testtest4"),
                new UserEntity(5, 55L, "testtest5"),
                new UserEntity(6, 66L, "testtest6"),
                new UserEntity(7, 77L, "testtest7"));
    }
}
