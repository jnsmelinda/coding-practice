package leetcode.p07.reverse_integer;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long z = 0;

        while (x != 0) {
            long lastDigit = x % 10;

            if (z != 0) {
                z *= 10;
                z += lastDigit;
            }
            else {
                z += lastDigit;
            }

            x /= 10;
        }

        if (x < 0) {
            z = 0 - z;
        }

        if (z > Integer.MAX_VALUE || z < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)z;
    }
}
