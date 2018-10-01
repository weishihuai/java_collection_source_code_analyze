package com.wsh;


/**
 * @Description: 测试
 * @Auther: weishihuai
 * @Date: 2018/10/1 21:11
 */
public class TestCustomSet {

    public static void main(String[] args) {
        CustomSet customSet = new CustomSet();

        customSet.add("aaa");
        customSet.add(new String("aaa"));
        //1
        System.out.println(customSet.size());
        //false
        System.out.println(customSet.isEmpty());

        customSet.add("bbb");
        customSet.remove("aaa");
        //1
        System.out.println(customSet.size());
        //true
        System.out.println(customSet.contains("bbb"));
    }

}
