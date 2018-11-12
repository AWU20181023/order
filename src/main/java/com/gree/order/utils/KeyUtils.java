package com.gree.order.utils;

import java.util.Random;

/**
 * Created by 260152(AWU) on 2018/10/30 16:13.
 */
public class KeyUtils {
    private KeyUtils() {
    }

    public static String getKey() {
        long l = System.currentTimeMillis();
        Random random = new Random();
        int i = random.nextInt(900000) + 100000;
        return l + String.valueOf(i);
    }

    public static void main(String[] args) {
        System.out.println(getKey());
    }
}
