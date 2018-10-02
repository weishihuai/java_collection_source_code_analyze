package com.wsh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: List接口遍历方法
 * @Author: weishihuai
 * @Date: 2018/10/2 09:28
 */
public class TestList {

    private static List<String> list = new ArrayList<>();

    static {
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
    }

    public static void main(String[] args) {
        /**
         * 方法一: 使用for循环
         */
        for (int i = 0,size = list.size(); i < size;i++) {
            //zhangsan lisi wangwu
            System.out.println(list.get(i));
        }

        /**
         * 方法二: 使用增强for循环
         */
        for (String string : list) {
            //zhangsan lisi wangwu
            System.out.println(string);
        }

        /**
         * 方法三: 使用Iterator方法
         */
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            //zhangsan lisi wangwu
            System.out.println(next);
        }

    }

}
