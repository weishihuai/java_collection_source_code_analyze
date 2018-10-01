package com.wsh;

import java.util.HashMap;

/**
 * @Description: 自定义HashSet, 帮助理解set底层实现
 * @Auther: weishihuai
 * @Date: 2018/10/1 20:55
 * <p>
 * 说明:
 * 1.Set底层是通过Map来实现的，Set的值作为Map中键
 * 2.Set中一些操作方法都是针对Map来操作
 * 3.Set不可重复就是利用map的键不可重复特性
 */
public class CustomSet {

    private HashMap map;
    private static final Object PRESENT = new Object();
    private int size;

    /**
     * 构造方法：创建一个Map结构用于存储Set
     */
    public CustomSet() {
        map = new HashMap<>();
    }

    /**
     * 往Set中新增元素
     * 原理: 对象作为Map中的键进行存储
     *
     * @param object 对象
     */
    public void add(Object object) {
        //Set不可重复就是利用Map的键不可重复特性
        map.put(object, PRESENT);
        size++;
    }

    /**
     * 返回Set中元素的个数
     *
     * @return Set中元素的个数
     */
    public int size() {
        return map.size();

    }

    /**
     * 判断Set是否为空
     *
     * @return 是否为空标志
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * 判断Set中是否包含某个对象
     * 原理: 实际上是调用的Map中containsKey()判断是否包含指定key元素的方法
     *
     * @param object 对象
     * @return
     */
    public boolean contains(Object object) {
        return map.containsKey(object);
    }

    /**
     * 移出Set中指定的对象
     * 原理: 实际上是调用的Map中移除元素的方法
     *
     * @param object 对象
     */
    public void remove(Object object) {
        map.remove(object);
    }
}
