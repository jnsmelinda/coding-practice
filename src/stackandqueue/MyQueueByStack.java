package stackandqueue;

import java.util.Stack;

public class MyQueueByStack {

    private static Stack<Integer> stack1, stack2;

    public MyQueueByStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public static void add(int n) {
        stack1.push(n);
        System.out.println(stack1);
    }

    private static void addHelper() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static int peek() {
        addHelper();
        return stack2.peek();
    }

    public static int remove() {
        addHelper();
        return stack2.pop();
    }

    @Override
    public String toString() {
        addHelper();
        return stack2.toString();
    }

    public static void main(String[] args) {
        MyQueueByStack queue = new MyQueueByStack();
        int[] arr = {1,2,3,4,5,6,7};
        for (int element : arr) {
            queue.add(element);
        }
        System.out.println(queue.remove());
        System.out.println(queue);
    }
}
