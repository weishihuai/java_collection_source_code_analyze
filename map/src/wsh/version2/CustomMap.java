package wsh.version2;

import java.util.LinkedList;

/**
 * 自定义Map(通过hashcode/equals方法实现，效率高)
 *
 * @author weishihuai
 * @date 2018/10/1 16:05
 * <p>
 * 说明:
 * Map底层结构是通过(数组 + 链表)实现,只是帮助理解一下Map大概实现原理，没必要自定义Map
 */
public class CustomMap {

    private LinkedList[] array = new LinkedList[1000];

    private int size;

    /**
     * 往Map中插入键值对元素
     *
     * @param key   键
     * @param value 值
     */
    public void put(Object key, Object value) {
        CustomEntry customEntry = new CustomEntry(key, value);
        int hashCode = key.hashCode();
        //根据hashCode计算出在bucket[]数组中的位置
        int index = hashCode % 1000;

        if (null == array[index]) {
            //空链表
            LinkedList linkedList = new LinkedList();
            array[index] = linkedList;
            linkedList.add(customEntry);
        } else {
            //不是空链表，拿出链表进行遍历，如果键值相同，值会被覆盖
            LinkedList list = array[index];
            for (int i = 0; i < list.size(); i++) {
                CustomEntry customEntry2 = (CustomEntry) list.get(i);
                if (customEntry2.getKey().equals(key)) {
                    //键值重复直接覆盖
                    customEntry2.setValue(value);
                    return;
                }
            }
            array[index].add(customEntry);
        }
        size++;
    }

    /**
     * 根据key找到对应的值
     *
     * @param key 键
     * @return 值
     * <p>
     * 原理: 根据key的hashCode计算出位置，如果该位置对应的链表不为空，循环遍历链表，找到对应的key,返回对应的值。如果未找到则返回null
     */
    public Object get(Object key) {
        int index = key.hashCode() % 1000;
        if (null != array[index]) {
            LinkedList list = array[index];
            for (int i = 0; i < list.size(); i++) {
                CustomEntry customEntry = (CustomEntry) list.get(i);
                if (customEntry.getKey().equals(key)) {
                    return customEntry.getValue();
                }
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
}
