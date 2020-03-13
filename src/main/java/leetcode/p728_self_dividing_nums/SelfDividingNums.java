package leetcode.p728_self_dividing_nums;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNums {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        int num = left;
        while (num >= left && num <= right) {
            if (getNum(num) == true) {
                result.add(num);
            }
            num++;
        }
        return result;
    }

    private static boolean getNum(int num) {
        int divisor = num;
        while (divisor > 0) {
            if (divisor % 10 == 0) {
                return false;
            }
            else if (num % (divisor % 10) != 0) {
                return false;
            }
            divisor /= 10;
        }
        return true;
    }
}
