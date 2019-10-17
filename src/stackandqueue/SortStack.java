package stackandqueue;

import java.util.Stack;

public class SortStack {
    private static Stack<Integer> stack;

    public SortStack() {
        stack = new Stack();
    }

    public static void push(int n) {
        Stack<Integer> helper = new Stack();
        pushHelper(n, helper);
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

    private static void pushHelper(int n, Stack helper) {
        if (stack.isEmpty() || stack.peek() <= n) {
            stack.push(n);
        }
        else {
            while (stack.peek() > n) {
                helper.push(stack.pop());
                pushHelper(n, helper);
            }
        }
    }

    public static int peek(){
        return stack.peek();
    }

    public static int pop() {
        return stack.pop();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        SortStack test = new SortStack();
        int[] arr = {5,2,7,5,0,1,6,4,7};
        for (int element : arr) {
            test.push(element);
        }
        System.out.println(test);
    }
}
