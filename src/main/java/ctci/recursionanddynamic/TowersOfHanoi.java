package ctci.recursionanddynamic;

import java.util.Stack;

public class TowersOfHanoi {

    public static void main(String[] args) {
        Stack<Integer> source = new Stack<>();
        Stack<Integer> spare = new Stack<>();
        Stack<Integer> target = new Stack<>();
        for (int i = 3; i >= 1; i--) {
            source.add(i);
        }
        System.out.println("source: " + source);
        towersOfHanoi(source.size(), source, target, spare);
        System.out.println("target: " + target);
    }

    private static void towersOfHanoi(int sourceSize, Stack source, Stack target, Stack spare) {
        if (sourceSize <= 0) {
            return;
        }
        towersOfHanoi(sourceSize - 1, source, spare, target);
        target.add(source.pop());
        towersOfHanoi(sourceSize - 1, spare, target, source);
    }
}
