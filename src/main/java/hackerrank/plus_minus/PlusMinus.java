package hackerrank.plus_minus;

public class PlusMinus {
    public static void main(String[] args) {
        int[] array = {1, 5, -4, 2, -7, 0, 0, 0};
        plusMinus(array);
    }
    static void plusMinus(int[] arr) {
        double neg = 0;
        double zero = 0;
        double poz = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                poz++;
            } else if(arr[i] < 0){
                neg++;
            }
            else {
                zero++;
            }
        }

        System.out.println(poz/arr.length);
        System.out.println(neg/arr.length);
        System.out.println(zero/arr.length);
    }
}
