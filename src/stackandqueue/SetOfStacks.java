package stackandqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {

    private static final List<Stack> listOfStack = new ArrayList<>();
    private static int stackCapacity;

    public SetOfStacks(int capacity) {
        stackCapacity = capacity;
    }

    public static List getStacks() {
        return listOfStack;
    }

    public static void push(int n) {
        if (getCurrentStack().size() == stackCapacity) {
            listOfStack.add(new Stack());
            getCurrentStack().push(n);
        }
        else if (getCurrentStack().size() < stackCapacity) {
            getCurrentStack().push(n);
        }
    }

    public static int pop() {
        if (getCurrentStack().isEmpty()) {
            throw new EmptyStackException();
        }
        int pop = (int) getCurrentStack().pop();
        if (getCurrentStack().size() == 0) {
            listOfStack.remove(getCurrentStack());
        }

        return pop;
    }

    private static Stack getCurrentStack(){
        if (listOfStack.isEmpty()) {
            listOfStack.add(new Stack());
        }

        return listOfStack.get(listOfStack.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        SetOfStacks test = new SetOfStacks(3);
        for (int element : arr) {
            test.push(element);
        }
        System.out.println(test.getStacks());
        System.out.println(test.getCurrentStack());
        System.out.println(test.pop());
        System.out.println(test.getStacks());
    }
}
