package com.ryan.java8.test;

import com.ryan.java8.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/4 13:20.
 */
public class StreamTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(StreamTestCase.class);

    private List<String> strList = new ArrayList<String>();
    private List<Integer> intList = new ArrayList<Integer>();

    private List<UserEntity> users = new ArrayList<>();

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
                new UserEntity(2, 22L, "testtest1"),
                new UserEntity(3, 33L, "testtest1"),
                new UserEntity(4, 44L, "testtest1"),
                new UserEntity(5, 55L, "testtest1"),
                new UserEntity(6, 66L, "testtest1"),
                new UserEntity(7, 77L, "testtest1"));
    }


    /**
     * @throws Exception
     */
    @Test
    public void testReduce() throws Exception {

        Integer reduce = intList.stream().reduce(0, (a, b) -> a + b);
        LOG.info("{}", reduce);

        Optional<Integer> max = intList.stream().reduce(Integer::max);
        LOG.info("Max Value : {}", max.get());

        Optional<Integer> min = intList.stream().reduce(Integer::min);
        LOG.info("Min Value : {}", min.get());

        long count = intList.stream().count();
        LOG.info("Count : {}", count);

    }

    /**
     * @throws Exception
     */
    @Test
    public void testUser() throws Exception {
        List<UserEntity> collect = users.stream().filter(user -> user.getUid() < 33).sorted(Comparator.comparing(UserEntity::getUid)).collect(Collectors.toList());
        for (UserEntity userEntity : collect) {
            LOG.info("{}", userEntity.toString());
        }

        OptionalLong max = users.stream().mapToLong(UserEntity::getSex).max();
        long maxV = max.orElse(0);

        LOG.info("{}", maxV);


    }

    @Test
    public void testRange() throws Exception {
        long count = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).count();

        LOG.info("Count : {}", count);


    }

    /**
     * 收集器 测试
     *
     * @throws Exception
     */
    @Test
    public void testCollectors() throws Exception {
        Collectors.maxBy(Comparator.comparingInt(UserEntity::getSex));

        Optional<UserEntity> collect = users.stream().collect(Collectors.maxBy(Comparator.comparing(UserEntity::getSex)));
        System.out.println(collect.get().getUsername());

        Integer summingInt = users.stream().collect(Collectors.summingInt(UserEntity::getSex));


        //链接字符串
        String joinStr = users.stream().map(UserEntity::getUsername).collect(joining(",,, "));
        System.out.println(joinStr);

    }

    /**
     * 勾股定理测试
     *
     * @throws Exception
     */
    @Test
    public void testGougu() throws Exception {
        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed().flatMap(
                a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
        );


        Stream<double[]> streamDouble = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
        ).filter(t -> t[2] % 1 == 0);


        stream.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


    }
}
