package com.wsh;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description: Set接口的遍历方法
 * @author: weishihuai
 * @Date: 2018/10/2 09:01
 */
public class TestSet {

    private static HashSet<String> hashSet = new HashSet<>();

    static {
        hashSet.add("zhangsan");
        hashSet.add("lisi");
        hashSet.add("wangwu");
    }

    public static void main(String[] args) {
        /**
         * 方法一: Iterator遍历
         */
        Iterator iterator = hashSet.iterator();
        //判断是否还有元素没有被遍历
        while (iterator.hasNext()) {
            //返回当前游标对应的元素，并把游标移向下一个元素
            String next = (String) iterator.next();
            //lisi zhangsan wangwu
            System.out.println(next);
        }

        for (Iterator iterator1 = hashSet.iterator(); iterator1.hasNext(); ) {
            //返回当前游标对应的元素，并把游标移向下一个元素
            String next = (String) iterator1.next();
            //lisi zhangsan wangwu
            System.out.println(next);
        }

        /**
         * 方法二: 使用增强for循环
         */
        for (String string : hashSet) {
            //lisi zhangsan wangwu
            System.out.println(string);
        }
    }

}
