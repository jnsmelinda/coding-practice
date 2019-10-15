package stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ThreeInOne {
    private static int stackNum;
    private static int stackCapacity;
    private static int[] arr;

    public ThreeInOne(int[] arr, int stackNum) {
        this.stackCapacity = arr.length / stackNum;
        this.stackNum = stackNum;
        this.arr = arr;
    }

    public static List makeStack() {
        int counter = 0;
        List list = new ArrayList();
        while (counter < stackNum) {
            list.add(addToStack(getSubArray(arr, counter), new Stack()));
            counter++;
        }
        return list;
    }


    public static int[] getSubArray(int[] arr, int counter) {
        int[] subArray = new int[stackCapacity];
        int subArrayIndex = 0;
        for (int i = counter * stackCapacity; i < (counter * stackCapacity) + stackCapacity; i++) {
            subArray[subArrayIndex] = arr[i];
            subArrayIndex++;
        }

        return subArray;
    }

    public static Stack addToStack(int[] arr, Stack stack) {
        for (int element : arr) {
            stack.push(element);
        }

        return stack;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        ThreeInOne test = new ThreeInOne(arr, 3);
        System.out.println(test.makeStack());
    }
}
