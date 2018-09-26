package com.wsh.linkedlist;

/**
 * 节点类
 *
 * @author weishihuai
 * @date 2018/9/26 21:14
 */
public class Node {
    /**
     * 前一个节点
     */
    private Node previous;
    /**
     * 下一个节点
     */
    private Node next;
    /**
     * 当前节点的值
     */
    private Object object;

    public Node() {
    }

    public Node(Node previous, Node next, Object object) {
        this.previous = previous;
        this.next = next;
        this.object = object;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
