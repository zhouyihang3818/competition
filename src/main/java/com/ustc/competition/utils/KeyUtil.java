package com.ustc.competition.utils;

import java.util.Random;

/**
 * @author yihangZhou
 * @create 2019-01-28 20:38
 */
public class KeyUtil {

    /**
     *  生成唯一的主键
     *  格式:随机数+时间*
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }

}
