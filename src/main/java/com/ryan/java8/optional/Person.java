package com.ryan.java8.optional;

import java.util.Optional;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 16:58.
 */
public class Person {

    private Optional<Car> car;

    private Car car2;

    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car2);
    }
}


