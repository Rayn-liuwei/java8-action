package com.ryan.java8.test;

import com.ryan.java8.oop.chain.responsibility.HeaderTextProcessing;
import com.ryan.java8.oop.chain.responsibility.ProcessingObject;
import com.ryan.java8.oop.chain.responsibility.SpellCheckeerProcessing;
import com.ryan.java8.oop.factory.Loan;
import com.ryan.java8.oop.factory.Product;
import com.ryan.java8.oop.factory.ProductFactory;
import com.ryan.java8.oop.observer.CCTV;
import com.ryan.java8.oop.observer.Feed;
import com.ryan.java8.oop.observer.Guardian;
import com.ryan.java8.oop.observer.LeMonde;
import com.ryan.java8.oop.strategy.IsAllLowerCase;
import com.ryan.java8.oop.strategy.IsNumeric;
import com.ryan.java8.oop.strategy.Validator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:01.
 */
public class OOPTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(OOPTestCase.class);

    /**
     * 测试 Lambda 策略模式
     *
     * @throws Exception
     */
    @Test
    public void testStrategy() throws Exception {
        Validator validator = new Validator(new IsNumeric());
        boolean stringValidator = validator.validate("dddd");

        Validator validator1 = new Validator(new IsAllLowerCase());
        boolean numericValidator = validator1.validate("ewe33333");
        LOG.info("{},  {}", stringValidator, numericValidator);


        /**
         * 下面为 Lambda 方式
         */
        Validator numbericValidator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean aaaa = numbericValidator.validate("aaaa");
        LOG.info("检查结果为:{}", aaaa);

        Validator lowerCaseValidator = new Validator((String s) -> s.matches("\\d+"));
        boolean dddd = lowerCaseValidator.validate("dddd");
        LOG.info("检查结果为:{}", dddd);

    }

    /**
     * 模板方法
     *
     * @throws Exception
     */
    @Test
    public void testSubject() throws Exception {
        Feed f = new Feed();

        f.registerObserver(new CCTV());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.notifyObservers("测试一条消息.cctv queen  wine");


        f.registerObserver((String twweet) -> {
            if (twweet.contains("money")) {
                System.err.println("我收到 Money 了，，好高兴。");
            }
        });

        f.notifyObservers("send a money");
    }

    /**
     * 责任链模式
     *
     * @throws Exception
     */
    @Test
    public void testChainResponsibility() throws Exception {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckeerProcessing();

        p1.setSuccessor(p2);

        String result = p1.handle("Arent't labdas really sexy ?!!");

        LOG.info("执行结果 : {}", result);


        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario And Alan : " + text;
        UnaryOperator<String> spellCheckeerProcessing = (String text) -> text.replaceAll("labda", "lambda");

        Function<String, String> pipline = headerProcessing.andThen(spellCheckeerProcessing);
        String text = pipline.apply("Arent't labdas really sexy ?!!");
        LOG.info("Lambda 执行结果 ：{}", text);

    }

    /**
     * 工厂模式测试
     *
     * @throws Exception
     */
    @Test
    public void testFactory() throws Exception {
        Product loan = ProductFactory.createProduct("loan");
        loan.processing();

        Supplier<Product> loanSupplier = Loan::new;
        Product product = loanSupplier.get();
        product.processing();
    }


}
