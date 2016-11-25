package com.ryan.java8.oop.chain.responsibility;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 14:26.
 */
public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    /**
     * @param input
     * @return
     */
    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    /**
     * 执行工作
     *
     * @param input
     * @return
     */
    public abstract T handleWork(T input);

}
