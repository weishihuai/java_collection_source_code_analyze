package com.wsh.linkedlist;

/**
 * 测试
 *
 * @author weishihuai
 * @date 2018/9/26 21:19
 */
public class TestCustomLinkedList {

    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        /***********************************add(object)***************************************/
        customLinkedList.add("aaa");
        customLinkedList.add("bbb");
        customLinkedList.add("ccc");

        /***********************************size()********************************************/
        //3
        System.out.println(customLinkedList.size());

        /***********************************get(index)****************************************/
        //bbb
        System.out.println(customLinkedList.get(1));
        //越界: java.lang.NullPointerException
        //System.out.println(customLinkedList.get(3));

        /***********************************remove(index)*************************************/
        //3
        System.out.println(customLinkedList.size());
        customLinkedList.remove(2);
        //2
        System.out.println(customLinkedList.size());

        /***********************************add(index,object)********************************/
        customLinkedList.add(1, "ddd");
        for (int i = 0; i < customLinkedList.size(); i++) {
            //aaa ddd bbb
            System.out.println(customLinkedList.get(i));
        }
    }

}
