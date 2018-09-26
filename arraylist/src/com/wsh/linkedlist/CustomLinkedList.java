package com.wsh.linkedlist;

/**
 * 自定义LinkedList,帮助理解底层实现
 *
 * @author weishihuai
 * @date 2018/9/26 21:14
 * <p>
 * 说明:
 * 1. LinkedList底层实现是双向链表,插入、修改、删除快，查询慢
 * 2. 基本操作的思想: 找到索引对应的元素，找到前一节点和后一节点，然后串起来一条链。
 */
public class CustomLinkedList {
    /**
     * 第一个节点
     */
    private Node first;
    /**
     * 最后一个节点
     */
    private Node last;
    /**
     * 链表长度
     */
    private int size;

    /**
     * 新增一个元素
     *
     * @param object 对象
     */
    public void add(Object object) {
        //如果第一个节点为空，说明为空链表
        if (null == first) {
            //创建一个新节点，赋值给first、last
            Node node = new Node();
            node.setPrevious(null);
            node.setNext(null);
            node.setObject(object);
            //新创建的节点既是第一个节点，也是最后一个节点
            first = node;
            last = node;
        } else {
            //直接在last后面添加一个新的节点
            Node node = new Node();
            node.setPrevious(last);
            node.setObject(object);
            node.setNext(null);
            //串成一条链
            last.setNext(node);
            //新创建的节点变成最后一个节点
            last = node;
        }
        //每新增一个节点，长度需要加1
        size++;
    }

    /**
     * 获取LinkedList的长度
     *
     * @return LinkedList的长度
     */
    public int size() {
        return size;
    }

    /**
     * 获取指定位置的元素
     * 原理: 从第一个节点开始，循环遍历节点，temp = temp.getNext()
     *
     * @param index 索引
     * @return 元素的值
     */
    public Object get(int index) {
        //判断索引是否越界
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标越界.....");
        }

        Node temp = null;
        if (null != first) {
            //0 1 2 3 4 5
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }
        return null != temp ? temp.getObject() : null;
    }

    /**
     * 删除指定索引的元素
     * 原理: 找到指定下标所对应的元素，找出该节点对应的上一个节点和下一个节点，把上一个节点的next指向下一个节点，下一个节点的previous指向上一个节点，这样就跳过了该节点，达到 删除的效果。
     *
     * @param index 索引
     */
    public void remove(int index) {
        //判断索引是否越界
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标越界.....");
        }

        Node temp = null;
        if (null != first) {
            //0 1 2 3 4 5
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }

        if (null != temp) {
            Node previous = temp.getPrevious();
            Node next = temp.getNext();
            previous.setNext(next);

            if (null != next) {
                next.setPrevious(previous);
            }

            size--;
        }

    }

    /**
     * 指定位置插入对象
     * 原理: 找到指定位置的元素，接着找到该节点对应的上一个节点，新建一个节点，用于连接之前的前后节点的桥梁
     *
     * @param index  索引
     * @param object 对象
     */
    public void add(int index, Object object) {
        //判断索引是否越界
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("下标越界.....");
        }

        Node temp = null;
        if (null != first) {
            //0 1 2 3 4 5
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }

        Node newNode = new Node();
        newNode.setObject(object);

        if (null != temp) {
            Node previous = temp.getPrevious();
            previous.setNext(newNode);
            newNode.setPrevious(previous);

            newNode.setNext(temp);
            temp.setPrevious(newNode);
            size++;
        }
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
