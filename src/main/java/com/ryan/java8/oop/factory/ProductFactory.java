package com.ryan.java8.oop.factory;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:38.
 */
public class ProductFactory {

    /**
     * 生产产品
     *
     * @param productName
     * @return
     */
    public static Product createProduct(String productName) {
        switch (productName) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such Product : " + productName);
        }
    }
}
