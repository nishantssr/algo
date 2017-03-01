package com.humsare.algo.list;

/**
 * Custom implementation of Linked List
 */
public class LinkedList {

    ListNode head;
    private int length = 0;

    public LinkedList() {
        length = 0;
    }

    public synchronized ListNode getHead() {
        return head;
    }

    public synchronized int getLength() {
        return length;
    }

    public synchronized boolean isEmpty() {
        return length == 0;
    }


    public synchronized void insertAtBegin(ListNode listNode) {
        listNode.setNext(head);
        head = listNode;
        length++;
    }

    public synchronized void insertAtEnd(ListNode listNode) {
        if (head == null) {
            head = listNode;
        } else {
            ListNode p, q;
            for (p = head; (q = p.getNext()) != null; p = q) ;
            p.setNext(listNode);
        }
        length++;
    }

    public synchronized void insertAtPosition(int data, int position) {

        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }

        if (head == null) {
            head = new ListNode(data);
        } // in front of the list
        else if (position == 0) {
            ListNode temp = new ListNode(data);
            temp.next = head;
            head = temp;
        } else {
            ListNode temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            ListNode newListNode = new ListNode(data);
            newListNode.next = temp;
            temp.setNext(newListNode);
        }
        length += 1;
    }

    public synchronized ListNode removeFromBegin() {
        ListNode listNode = head;
        if (listNode != null) {
            head = listNode.getNext();
            listNode.setNext(null);
        }
        return listNode;
    }


    public synchronized ListNode getLast() {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }
        ListNode p = head.getNext();
        while (p.getNext() != null) {
            p = p.getNext();
        }
        return p;
    }

    public synchronized ListNode removeFromEnd() {
        if (head == null) {
            return null;
        }

        ListNode p = head, q = null, next = p.getNext();
        if (next == null) {
            head = null;
            length -= 1;
            return p;
        }

        while ((next = p.getNext()) != null) {
            q = p;
            p = p.getNext();
        }
        q.setNext(null);
        length -= 1;
        return p;
    }


    public synchronized void removeMatched(ListNode node) {
        if (head == null) {
            return;
        }
        if (head.equals(node)) {
            head = head.getNext();
            length -= 1;
            return;
        }
        ListNode p = head, q = null;
        while ((q = p.getNext()) != null) {
            if (node.equals(q)) {
                p.setNext(q.getNext());
                length -= 1;
            }
            p = q;
        }
    }


    public synchronized void remove(int position) {

        if (position < 0) {
            position = 0;
        }

        if (position >= length) {
            position = length;
        }

        if (head == null) {
            return;
        }

        if (position == 0) {
            head = head.getNext();
        } else {
            ListNode temp = head;

            for (int i = 1; i < position; i += 1) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length -= 1;
    }

    public int getPosition(int data) {
        ListNode temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.getData() == data) {
                return pos;
            }
            pos += 1;
            temp = temp.getNext();
        }
        return Integer.MIN_VALUE;
    }

    public String toString() {
        String result = "[";
        if (head == null) {
            return result + "]";
        }
        result = result + head.getData();
        ListNode temp = head.getNext();
        while (temp != null) {
            result = result + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    public void clearlist() {
        head = null;
        length = 0;
    }


}
