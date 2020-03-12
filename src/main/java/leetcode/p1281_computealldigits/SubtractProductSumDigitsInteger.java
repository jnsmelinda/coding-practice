package leetcode.p1281_computealldigits;

public class SubtractProductSumDigitsInteger {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(710));
    }

    public static int subtractProductAndSum(int n) {
        int multiplicative = 1;
        int additive = 0;
        while (n > 0) {
            multiplicative *= n%10;
            additive += n%10;
            n = n / 10;
        }

        return multiplicative - additive;
    }
}
