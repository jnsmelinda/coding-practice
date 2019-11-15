package ctci.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ThreeInOne {
    private static int stackCapacity;

    public static List makeStack(int[] arr, int stackNum) {
        stackCapacity = arr.length / stackNum;
        int counter = 0;
        List list = new ArrayList();
        while (counter < stackNum) {
            list.add(addToStack(getSubArray(arr, counter), new Stack()));
            counter++;
        }

        return list;
    }


    private static int[] getSubArray(int[] arr, int counter) {
        int[] subArray = new int[stackCapacity];
        int subArrayIndex = 0;
        for (int i = counter * stackCapacity; i < (counter * stackCapacity) + stackCapacity; i++) {
            subArray[subArrayIndex] = arr[i];
            subArrayIndex++;
        }

        return subArray;
    }

    private static Stack addToStack(int[] arr, Stack stack) {
        for (int element : arr) {
            stack.push(element);
        }

        return stack;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(makeStack(arr, 3));
    }
}
