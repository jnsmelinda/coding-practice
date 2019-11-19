package ctci.recursionanddynamic;

import java.util.HashMap;
import java.util.Map;

public class TripleSteps {

    public static int steps(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        else {
            return steps(n-1) + steps(n-2) + steps(n-3);
        }
    }

    public static int stepsMemo(int n) {
        return stepsMemo(n, new HashMap<>());
    }

    public static int stepsMemo(int n, Map<Integer, Integer> map) {
        if (n < 0) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        }
        else if (map.containsKey(n)) {
            return map.get(n);
        }
        else {
            int value = stepsMemo(n-1, map) + stepsMemo(n-2, map) + stepsMemo(n-3, map);
            map.put(n, value);
            return value;
        }
    }

    public static int stepsDP(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }

        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(stepsDP(5));
    }
}
