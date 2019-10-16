package stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {

    private static List<Stack> listOfStack;
    private static int stackCapacity;
    private static Stack currentStack;

    public SetOfStacks(int capacity) {
        listOfStack = new ArrayList<>();
        stackCapacity = capacity;
    }

    public static List getStacks() {
        return listOfStack;
    }

    public static void push(int n) {
        if (currentStack == null || currentStack.size() == stackCapacity) {
            currentStack = new Stack();
            currentStack.push(n);
            listOfStack.add(currentStack);
        }
        else if (currentStack.size() < stackCapacity) {
            currentStack.push(n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        SetOfStacks test = new SetOfStacks(3);
        for (int element : arr) {
            test.push(element);
        }
        System.out.println(test.getStacks());

    }
}
