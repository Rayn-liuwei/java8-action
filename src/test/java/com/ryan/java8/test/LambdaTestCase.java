package com.ryan.java8.test;

import com.ryan.java8.callback.BufferedReaderProcessor;
import com.ryan.java8.callback.Callback;
import com.ryan.java8.defaultmethod.HelloImpl;
import com.ryan.java8.defaultmethod.HelloImplD;
import com.ryan.java8.entity.UserEntity;
import com.ryan.java8.optional.Car;
import com.ryan.java8.optional.Insurance;
import com.ryan.java8.optional.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 11:35.
 */
public class LambdaTestCase extends Data {

    private static final Logger LOG = LoggerFactory.getLogger(LambdaTestCase.class);

    /**
     * 匿名类写法
     *
     * @throws Exception
     */
    @Test
    public void testAnnoClass() throws Exception {
        Runnable runnable = () -> LOG.info("Runnable");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                LOG.info("Runnable");
            }
        };

    }


    public void doSomeThing(Runnable runnable) {
        runnable.run();
    }

    public void doSomeThing(Callback runnable) {
        runnable.compute();
    }

    /**
     * doSomething
     *
     * @throws Exception
     */
    @Test
    public void testDoSomething() throws Exception {

        //请注意这里的 (Callback) ，显示的类型转换类解决这种模棱两可的情况。
        doSomeThing((Callback) () -> {
            LOG.info("到底是调用了那个方法？");
        });

    }


    /**
     * @param p
     * @return
     */
    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("./POM.xml"))) {
            return p.process(br);
        }
    }

    /**
     * 从方法引用的转换
     *
     * @throws Exception
     */
    @Test
    public void testMethodRefOfConvert() throws Exception {
        Map<Long, List<UserEntity>> collect = users.stream().collect(Collectors.groupingBy(UserEntity::getUid));


        Integer sum = users.stream().map(UserEntity::getSex).reduce(0, (c1, c2) -> c1 + c2);
        LOG.info("{}", sum);

        List<String> sumAge = users.parallelStream().filter(d -> d.getUid() > 30).map(UserEntity::getUsername).collect(Collectors.toList());
        LOG.info("{}", sumAge);


        String online = processFile((BufferedReader b) -> b.readLine());
        LOG.info("{}", online);


    }

    /**
     * 多继承 default 方法 测试
     *
     * @throws Exception
     */
    @Test
    public void testHello() throws Exception {

        /**
         * 这里需要注意  HelloB 继承与不继承的区别
         */
        HelloImpl hello = new HelloImpl();
        hello.hello();

        new HelloImplD().hello();
    }

    /**
     * Optional 测试
     *
     * @throws Exception
     */
    @Test
    public void testOptional() throws Exception {
        /**
         * 创建一个空的 Optional
         */
        Optional<Person> empty = Optional.empty();

        /**
         * 依据非空值创建 Optional
         */
        Optional<Person> person = Optional.of(new Person());

        /**
         * 可接受 null 的 optional
         */
        Optional<Person> nullOptional = Optional.ofNullable(null);


        Optional<Insurance> insuranceOptional = Optional.of(new Insurance());
        Optional<String> nameOpt = insuranceOptional.map(Insurance::getName);
        String name = nameOpt.orElse("test");
        LOG.info("{}", name);

        /**
         * 嵌套获取对象
         */
        final String nestedValue = person.flatMap(Person::getCarAsOptional).flatMap(Car::getInsurance).map(Insurance::getName).orElse("null");
        LOG.info("nested value is : {}", nestedValue);


        person.ifPresent(c -> {
            System.out.println("存在值");
        });

        person.orElseThrow(() -> {
            throw new IllegalArgumentException("非法数据");
        });

    }
}
