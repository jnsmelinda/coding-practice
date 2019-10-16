package stackandqueue;

import java.util.Stack;
public class StackMin extends Stack<Integer>{
    private static Stack<Integer> stackOfMin;

    StackMin() {
        stackOfMin = new Stack<>();
    }

    public int getMin() {
        if (super.isEmpty()) {
            System.out.print("empty stack ");
            return Integer.MAX_VALUE;
        }
        return stackOfMin.peek();
    }

    public void push(int n) {
        if (stackOfMin.isEmpty() || n <= stackOfMin.peek()) {
            stackOfMin.push(n);
        }
        super.push(n);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == stackOfMin.peek()) {
            stackOfMin.pop();
        }
        return value;
    }

    public static void main(String[] args) {
        StackMin test = new StackMin();
        int[] arr = {8,5,2,0,3,2,6,-1};
        for (int element : arr) {
            test.push(element);
        }
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.getMin());
    }
}
