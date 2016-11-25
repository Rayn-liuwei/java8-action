package com.ryan.java8.callback;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/25 12:00.
 */
public interface BufferedReaderProcessor {

    /**
     *
     * @param b
     * @return
     * @throws IOException
     */
    public String process(BufferedReader b) throws IOException;
}
