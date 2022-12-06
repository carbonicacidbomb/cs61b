package deque;

public class ArrayDeque<T> implements TheDequeAPI<T> {
    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int cap;

    /** create an empty ArrayDeque */
    public ArrayDeque() {
        cap = 8;
        array = (T[]) new Object[cap];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    /** Set the index */
    private int set(int index) {
        if (index < 0) {
            index += cap;
        }
        return index % cap;
    }

    /** Resize the ArrayDeque */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int i = set(nextFirst + 1);
        int x = 0;
        while (x < size) {
            a[x] = array[i];
            x += 1;
            i = set(i + 1);
        }
        array = a;
        cap = capacity;
        nextFirst = cap - 1;
        nextLast = size;
    }

    @Override
    /** Adds item to the front of the list. */
    public void addFirst(T item) {
        if (size == cap) {
            resize(size * 2);
        }
        array[nextFirst] = item;
        size += 1;
        nextFirst = set(nextFirst - 1);
    }

    @Override
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item){
        if (size == cap){
            resize(size * 2);
        }
        array[nextLast] = item;
        size += 1;
        nextLast = set(nextLast + 1);
    }

    @Override
    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
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
        int i = 0;
        while (i < size) {
            System.out.print(array[set(nextFirst + 1 + i)]);
            i += 1;
        }
        System.out.println();
    }

    @Override
    /** Removes and returns the item at the front of the deque. */
    public T removeFirst() {
        if (size == 0) {
           return null;
        } else {
            T first = array[set(nextFirst + 1)];
            array[set(nextFirst + 1)] = null;
            size -= 1;
            nextFirst = set(nextFirst + 1);
            if (cap > 16 && size < cap / 4) {
                resize(size * 2);
            }
            return first;
        }
    }

    @Override
    /** Removes and returns the item at the back of the deque. */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T last = array[set(nextLast - 1)];
            array[set(nextLast - 1)] = null;
            size -= 1;
            nextLast = set(nextLast - 1);
            if (cap > 16 && size < cap / 4) {
                resize(size * 2);
            }
            return last;
        }
    }

    @Override
    /**  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. */
    public T get(int index) {
        int i;
        i = set(nextFirst + 1 + index);
        return array[i];
    }
}
