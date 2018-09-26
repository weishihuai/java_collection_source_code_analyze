package com.wsh.arraylist;

/**
 * 自定义一个简单的ArrayList,帮助理解ArrayList底层原理
 *
 * @author weishihuai
 * @date 2018/9/25
 * <p>
 * 说明:
 * 1. ArrayList底层实现是数组,所有对数据的操作其实底层都是对Object[]数组的操作。
 * 2. ArrayList查询快(索引),新增、修改、删除慢(需要修改下标)
 * 3. ArrayList默认创建大小为10的对象数组，如果超过十个元素会进行扩容。
 * 4. 本类只实现了部分常见的方法，帮助自己理解而已。
 */
public class CustomArrayList {

    /**
     * 数组初始化大小(默认为10)
     */
    private static final int DEFAULT_INIT_NUM = 10;

    /**
     * 数组的大小
     */
    private int size;

    /**
     * 存放数据的对象数组
     */
    private Object[] data;

    /**
     * 无参构造方法
     */
    public CustomArrayList() {
        this(DEFAULT_INIT_NUM);
    }

    /**
     * 有参构造方法
     *
     * @param initNum 指定大小
     */
    public CustomArrayList(int initNum) {
        //如果初始化大小小于0
        if (initNum < 0) {
            throw new IllegalArgumentException("数组初始化大小不能小于0");
        }
        //创建指定大小的对象数组
        data = new Object[initNum];
    }

    /**
     * 新增元素
     *
     * @param object 对象
     */
    public void add(Object object) {
        //数组扩容处理
        //创建新数组，复制原数组到新数组，返回新的数组
        if (size == data.length) {
            Object[] newData = new Object[size * 2 + 1];
//            for(int i = 0 ; i < data.length ; i++) {
//                newData[i] = data[i];
//            }
            //拷贝数组
            System.arraycopy(data, 0, newData, 0, data.length);
            //替换原数组
            data = newData;
        }


        data[size] = object;
        //每次新增完元素大小需要加1
        size++;
    }

    /**
     * 获取List的大小
     *
     * @return List的大小
     */
    public int size() {
        return size;
    }

    /**
     * List是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 根据下标获取对应的值
     *
     * @param index 下标索引
     * @return
     */
    public Object get(int index) {
        //判断索引是否合法
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标索引非法，下标越界");
        }
        return data[index];
    }

    /**
     * 根据索引删除指定位置的对象
     * 原理: 被删除下标以后的元素依次往前移
     *
     * @param index 下标索引
     * @return 被删除的旧数据
     */
    public Object remove(int index) {
        Object old = data[index];
        //判断索引是否合法
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标索引非法，下标越界");
        }
        //原理：数组copy
        int num = size - index - 1;
        if (num > 0) {
            System.arraycopy(data, index + 1, data, index, num);
        }

        data[--size] = null;
//        data[size - 1] = null;
//        size--;

        //返回被删除的旧数据
        return old;
    }

    /**
     * 删除指定值的元素
     * 原理: 循环遍历数组，使用equals比较值是否相等，找到第一个匹配的数组元素的下标，根据该下标进行删除
     *
     * @param object 指定值
     * @return
     */
    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 给指定索引下标赋值
     * 原理：替换原数组下标的值
     * 下标索引
     *
     * @param index
     * @param object 对象
     */
    public Object set(int index, Object object) {
        //判断索引是否合法
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标索引非法，下标越界");
        }

        Object oldValue = data[index];
        data[index] = object;
        return oldValue;
    }

    /**
     * 指定位置添加值
     * 原理: 数组copy,依次往后移，空出当前index位置存放object对象
     *
     * @param index  下标索引
     * @param object 对象
     */
    public void add(int index, Object object) {
        //判断索引是否合法
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标索引非法，下标越界");
        }

        //数组的扩容
        if (size == data.length) {
            Object[] newData = new Object[size * 2 + 1];
            //拷贝数组
            System.arraycopy(data, 0, newData, 0, data.length);
            //替换原数组
            data = newData;
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = object;
        size++;
    }

    /**
     * 根据指定值查找下标，未找到返回-1
     * 原理: 循环遍历数组，使用equals方法判断值是否相等，返回第一个匹配的下标索引，未找到返回-1
     *
     * @param object 对象
     * @return 下标索引
     */
    public int indexOf(Object object) {
        if (null == object) {
            for (int i = 0; i < size; i++) {
                if (null == data[i]) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 从后往前找指定值对应的下标索引
     * 原理:  倒序循环遍历数组，使用equals方法判断是否相等，找到返回对应的下标索引，未找到返回-1
     *
     * @param object 指定值
     * @return 下标索引
     */
    public int lastIndexOf(Object object) {
        if (null == object) {
            for (int i = size - 1; i >= 0; i--) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

}
