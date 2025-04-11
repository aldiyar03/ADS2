public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing MyArrayList ===");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.sort();
        for (int i : arrayList) System.out.println(i);

        System.out.println("\n=== Testing MyLinkedList ===");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(8);
        linkedList.sort();
        for (int i : linkedList) System.out.println(i);

        System.out.println("\n=== Testing MyStack ===");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(100);
        stack.push(200);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println("\n=== Testing MyQueue ===");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());

        System.out.println("\n=== Testing MyMinHeap ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(3);
        heap.add(1);
        heap.add(2);
        System.out.println(heap.poll());
        System.out.println(heap.peek());
    }
}
