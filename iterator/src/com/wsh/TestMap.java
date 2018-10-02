package com.wsh;

import java.util.*;

/**
 * @Description: Map接口的遍历方法
 * @Author: weishihuai
 * @Date: 2018/10/2 09:52
 */
public class TestMap {

    private static HashMap<String,Object> hashMap = new HashMap<>();

    static {
        hashMap.put("name","zhangsan");
        hashMap.put("age","20");
        hashMap.put("sex","male");
    }

    public static void main(String[] args) {
        /**
         * 方法一: 使用 hashMap.entrySet() 循环
         */
        for(Map.Entry<String,Object> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
//            sex=====>male
//            name=====>zhangsan
//            age=====>20
            System.out.println(key + "=====>" + value);
        }

        /**
         * 方法二: 使用Iterator接口遍历
         */
        Iterator<Map.Entry<String, Object>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            String key = entry.getKey();
            String value = (String) entry.getValue();
//            sex=====>male
//            name=====>zhangsan
//            age=====>20
            System.out.println(key + "=====>" + value);
        }

        /**
         * 方法三: 使用 hashMap.keySet()/hashMap.values()/Iterator
         */
        Set<String> strings = hashMap.keySet();
        Collection<Object> values = hashMap.values();
        for (Iterator<String> iterator1 = strings.iterator();iterator1.hasNext();) {
            String key = iterator1.next();
            String value = (String) hashMap.get(key);
//            sex=====>male
//            name=====>zhangsan
//            age=====>20
            System.out.println(key + "=====>" + value);
        }
        for (Iterator i = values.iterator(); i.hasNext();) {
            String s = (String) i.next();
            // 循环输出value
//            male
//            zhangsan
//            20
            System.out.println(s);
        }

        /**
         * 方法四: 使用hashMap.keySet()/forEach 遍历
         */
        for (String key : hashMap.keySet()) {
            String value = (String) hashMap.get(key);
//            sex=====>male
//            name=====>zhangsan
//            age=====>20
            System.out.println(key + "=====>" + value);
        }

    }

}
