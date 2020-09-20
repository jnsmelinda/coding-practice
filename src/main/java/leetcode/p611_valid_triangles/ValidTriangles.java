package leetcode.p611_valid_triangles;

import java.util.Arrays;

public class ValidTriangles {

    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int k = j + 1;
                for (k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k])  {
                        ++count;
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }
}
