package leetcode.p1313_decompress;

import java.util.Arrays;

public class Decopress {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(decompressRLElist(arr)));
    }

    public static int[] decompressRLElist(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i += 2) {
            counter += nums[i];
        }

        int[] result = new int[counter];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];

            while (freq > 0) {
                result[index] = val;
                freq--;
                index++;
            }
        }

        return result;
    }
}
