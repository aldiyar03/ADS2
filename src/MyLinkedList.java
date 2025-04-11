public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private class MyNode {
        T item;
        MyNode next;
        MyNode prev;

        public MyNode(T item) {
            this.item = item;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode node = new MyNode(item);
        if (tail == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        MyNode node = new MyNode(item);
        node.prev = current.prev;
        node.next = current;
        current.prev.next = node;
        current.prev = node;
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode current = getNode(index);
        current.item = item;
    }

    @Override
    public T get(int index) {
        return getNode(index).item;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException();
        return head.item;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException();
        return tail.item;
    }

    @Override
    public void remove(int index) {
        MyNode node = getNode(index);
        unlink(node);
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException();
        unlink(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException();
        unlink(tail);
    }

    private void unlink(MyNode node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
    }

    @Override
    public void sort() {
        if (size < 2) return;
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if (i.item.compareTo(j.item) > 0) {
                    T temp = i.item;
                    i.item = j.item;
                    j.item = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode current = head; current != null; current = current.next) {
            if (current.item.equals(object)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode current = tail; current != null; current = current.prev) {
            if (current.item.equals(object)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (MyNode current = head; current != null; current = current.next) {
            array[i++] = current.item;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            MyNode current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
