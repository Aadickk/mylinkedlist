public abstract class MyLinkedList<T> implements asd<T> {

    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public T removeFirst() {
        if (length == 0) {
            return null;
        }
        else {
            MyNode<T> temp = head;
            head = head.next;
            length--;
            if (head == null) {
                tail = null;
            }
            return temp.data;
        }
    }


    public T removeLast() {
        if (length == 0) {
            return null;
        }
        else if (length == 1) {
            MyNode<T> temp = head;
            head = tail = null;
            length = 0;
            return temp.data;
        }
        else {
            MyNode<T> current = head;

            for (int i = 0; i < length - 2; i++) {
                current = current.next;
            }

            MyNode<T> temp = tail;
            tail = current;
            tail.next = null;
            length--;
            return temp.data;
        }
    }

    public T get(int ind) {
        if (ind >= length || ind < 0)
            throw new IndexOutOfBoundsException("index >=0 and <length");

        MyNode<T> temp = head;

        while (ind != 0) {
            temp = temp.next;
            ind--;
        }

        return temp.data;
    }

    public int length() {
        return length;
    }


    @Override
    public void add(int index, T e) {
        if (index == 0) {
            add(e);
        }
        else if (index >= length) {
            add(e);
        }
        else {
            MyNode<T> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            MyNode<T> temp = current.next;
            current.next = new MyNode<T>(e);
            (current.next).next = temp;
            length++;
        }
    }
    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == length - 1) {
            return removeLast();
        }
        else {
            MyNode<T> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            MyNode<T> current = previous.next;
            previous.next = current.next;
            length--;
            return current.data;
        }
    }
    @Override
    public void clear() {
        length = 0;
        head = tail = null;
    }
    public boolean contains(T e) {
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(e))
                return true;
            current = current.next;
        }

        return false;
    }

    @Override
    public int indexOf(T e) {
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(e))
                return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T e) {
        MyNode<T> current = head;
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(e))
                lastIndex = i;
            current = current.next;
        }
        return lastIndex;
    }


}

