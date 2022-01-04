package leetcode.p225_stack_using_2_queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(9);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(obj);
    }

    public static class MyStack {
        public Queue<Integer> queue1;
        public Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue1.add(x);
        }

        public int pop() {
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            int num = queue1.remove();
            queue1 = queue2;
            queue2 = new LinkedList<>();

            return num;
        }

        public int top() {
            while (queue1.size() > 1){
                queue2.add(queue1.remove());
            }
            int num = queue1.peek();
            queue2.add(num);
            queue1 = queue2;
            queue2 = new LinkedList<>();

            return num;
        }

        public boolean empty() {
            if (queue1.size() > 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "MinStack{" +
                "list=" + queue1 + "}";
        }
    }
}
