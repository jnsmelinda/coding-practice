package ctci.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String value = Optional.ofNullable(getValue())
                .filter(v -> v.startsWith("b"))
                .map(v -> "---" + v)
                .orElse("nincs");

        System.out.println(value);

        List<Integer> list = new ArrayList<>();
        list.add(1);

        Integer[] arrayType = new Integer[1];
        Integer[] array = list.toArray(arrayType);

        int[] a = list.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(a));
    }

    private static String getValue() {
        return "abc";
//        return null;
    }

    public int find(int[] nums) {
        return (int) Arrays.stream(nums)
            .mapToObj(num -> String.valueOf(num))
            .filter(str -> str.length() % 2 == 0)
            .count();
    }
}
