package com.humsare.algo.list;

/**
 * Class for holding data and next node information.
 */
public class ListNode {
    // point to next node in the list, would be null at tail.
    public ListNode next;
    // list specific data, here this is int.
    public int data;

    //init with default value
    public ListNode() {
        next = null;
        data = Integer.MIN_VALUE;
    }
    //init with provided value
    public ListNode(int data) {
        next = null;
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}


