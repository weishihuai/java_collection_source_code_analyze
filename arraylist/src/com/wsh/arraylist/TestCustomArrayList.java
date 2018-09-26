package com.wsh.arraylist;

/**
 * 测试自定义ArrayList
 *
 * @author weishihuai
 * @date 2018/9/25
 */
public class TestCustomArrayList {

    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList();

        /***********************************add(object)***************************************/
        customArrayList.add("aaa");
        customArrayList.add("bbb");
        customArrayList.add("ccc");
        customArrayList.add("ddd");

        /***********************************size()********************************************/
        //4
        System.out.println(customArrayList.size());

        /***********************************isEmpty()*****************************************/
        //false
        System.out.println(customArrayList.isEmpty());

        /***********************************get(index)****************************************/
        //Exception in thread "main" java.lang.IllegalArgumentException: 数组下标索引非法，下标越界
        //System.out.println(customArrayList.get(10));
        //ccc
        System.out.println(customArrayList.get(2));

        /***********************************remove(index)*************************************/
        //ccc
        System.out.println(customArrayList.remove(2));
        //3
        System.out.println(customArrayList.size());
        //true
        System.out.println(customArrayList.remove("bbb"));
        //2
        System.out.println(customArrayList.size());

        /***********************************set(index,object)*********************************/
        //ddd
        System.out.println(customArrayList.get(1));
        //ddd
        System.out.println(customArrayList.set(1, "1111"));
        //1111
        System.out.println(customArrayList.get(1));

        /***********************************add(index,object)*********************************/
        customArrayList.add(1, "2222");
        //2222
        System.out.println(customArrayList.get(1));
        for (int i = 0; i < customArrayList.size(); i++) {
            //aaa=====2222=====1111=====
            System.out.print(customArrayList.get(i) + "=====");
            System.out.println();
        }

        /***********************************indexOf(object)************************************/
        //1
        System.out.println(customArrayList.indexOf("2222"));
        //-1
        System.out.println(customArrayList.indexOf("abcdef"));

        /***********************************lastIndexOf(object)********************************/
        //0
        System.out.println(customArrayList.lastIndexOf("aaa"));
    }

}
