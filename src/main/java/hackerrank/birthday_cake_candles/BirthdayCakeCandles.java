package hackerrank.birthday_cake_candles;

import java.util.Arrays;

public class BirthdayCakeCandles {
    public static void main(String[] args) {
        int[] ar = {1,6,3,6,4,5,6};
        System.out.println(birthdayCakeCandles(ar));
    }

    public static int birthdayCakeCandles(int[] ar) {
        Arrays.sort(ar);

        int counter = 0;
        for (int i = ar.length - 1; i >= 0; i--) {
            if (ar[i] == ar[ar.length - 1]) {
                counter++;
            }
            else {
                break;
            }
        }
        return counter;
    }
}
