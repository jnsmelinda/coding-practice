package leetcode.p011_container_with_most_water;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;

        int max = Integer.MIN_VALUE;

        while (begin <= end) {
            max = Math.max(max, (Math.min(height[end], height[begin]) * (end - begin)));

            if (height[end] < height[begin]) {
                end--;
            }
            else {
                begin++;
            }
        }

        return max;
    }
}
