package leetcode.p155_min_stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStack {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(4);
        System.out.println(obj);
        obj.pop();
        System.out.println(obj);
//        int param_3 = obj.top();
//        int param_4 = obj.getMin();
    }

    private List<Integer> list;
    public int min;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
        if (list.size() == 1) {
            min = val;
        }
        if (val < min) {
            min = val;
        }
    }

    public void pop() {
        list.remove((list.size() - 1));
        if (list.size() != 0) {
            min = Collections.min(list);
        }
        else {
            min = 0;
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return min;
    }

     @Override
     public String toString() {
         return "MinStack{" +
             "list=" + list +
             ", min=" + min +
             '}';
     }
 }
