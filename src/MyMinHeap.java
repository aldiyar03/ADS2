public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void add(T item) {
        list.add(item);
        heapifyUp();
    }

    public T poll() {
        if (list.size() == 0) throw new IllegalStateException();
        T root = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.removeLast();
        heapifyDown();
        return root;
    }

    public T peek() {
        if (list.size() == 0) throw new IllegalStateException();
        return list.get(0);
    }

    private void heapifyUp() {
        int index = list.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = list.get(index);
            T parent = list.get(parentIndex);
            if (current.compareTo(parent) < 0) {
                list.set(index, parent);
                list.set(parentIndex, current);
                index = parentIndex;
            } else break;
        }
    }

    private void heapifyDown() {
        int index = 0;
        int size = list.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;
            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) smallest = left;
            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) smallest = right;
            if (smallest != index) {
                T temp = list.get(index);
                list.set(index, list.get(smallest));
                list.set(smallest, temp);
                index = smallest;
            } else break;
        }
    }
}
