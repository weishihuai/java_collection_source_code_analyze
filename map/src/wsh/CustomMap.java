package wsh;

/**
 * 自定义Map(版本一，效率较低，需要循环遍历找相同的key)
 *
 * @author weishihuai
 * @date 2018/9/27 21:25
 * 说明:
 * 1. Map是存放键值对(key-value)的数据结构
 * 2. Map键值不允许重复，如果重复会覆盖之前的值
 * 3. 根据键值可以找到对应的值
 */
public class CustomMap {

    private CustomEntry[] array = new CustomEntry[1000];

    private int size;

    /**
     * 往Map中新增元素
     * 原理: 新建Entry对象，往数组中添加元素即可
     *
     * @param key   键
     * @param value 值
     */
    public void put(Object key, Object value) {
        CustomEntry customEntry = new CustomEntry(key, value);
        //判断是否存在相同的键，如果有相同的直接覆盖之前的值，size不用改变。
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(key)) {
                array[i].setValue(value);
                return;
            }
        }
        array[size] = customEntry;
        size++;
    }

    /**
     * 根据键找到相应的值
     * 原理: 循环遍历entry数组中的key集合，找到返回键对应的值，未找到返回null
     *
     * @param key 键
     * @return 键对应的值
     */
    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(key)) {
                return array[i].getValue();
            }
        }
        return null;
    }

    /**
     * 判断是否存放指定key的元素
     * 原理: 循环遍历所有的key集合，找到返回true，找不到返回false
     *
     * @param key 键
     * @return 是否包含对应的键的元素
     */
    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否包含指定值的元素
     * 原理: 循环遍历所有的value集合，找到返回true，找不到返回false
     *
     * @param value 值
     * @return 是否包含指定值的元素
     */
    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回Map中元素的个数
     *
     * @return Map的元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断Map是否为空
     *
     * @return map是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }


}
