package deque;

import afu.org.checkerframework.checker.oigj.qual.O;

public class LinkedListDeque<T> implements TheDequeAPI<T> {
    private class Node {
       public T item;
       public Node next;
       public Node prev;
       public Node(Node p, T i, Node n) {
           item = i;
           prev = p;
           next = n;
       }
    }
    private Node sentinel;
    private int size;

    /** Creates an empty LinkedListDeque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T i) {
        sentinel = new Node(null, null, null);
        Node x = new Node(sentinel, i, sentinel);
        sentinel.next = x;
        sentinel.prev = x;
        size = 1;
    }

    @Override
    /** Adds item to the front of the list. */
    public void addFirst(T item) {
        Node x = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = x;
        sentinel.next = x;
        size += 1;
    }

    @Override
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        Node x = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = x;
        sentinel.prev = x;
        size += 1;
    }

    @Override
    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    @Override
    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            p = p.next;
        }
        System.out.println();
    }

    @Override
    /** Removes and returns the item at the front of the deque. */
    public T removeFirst() {
        Node x = sentinel.next;
        sentinel.next = x.next;
        x.next.prev = sentinel;
        if (x != sentinel) {
            size -= 1;
            return x.item;
        } else {
            return null;
        }
    }

    @Override
    /** Removes and returns the item at the back of the deque. */
    public T removeLast() {
        Node x = sentinel.prev;
        sentinel.prev = x.prev;
        x.prev.next = sentinel;
        if (x != sentinel) {
            size -= 1;
            return x.item;
        } else {
            return null;
        }
    }

    @Override
    /**  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. */
    public T get(int index) {
        Node x = sentinel.next;
        for (int i = 0; i < index; i += 1) {
            x = x.next;
        }
        return x.item;
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        return getRecursive(index - 1, sentinel.next);
    }

    private T getRecursive(int index, Node p) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursive(index - 1, p.next);
        }
    }
}
