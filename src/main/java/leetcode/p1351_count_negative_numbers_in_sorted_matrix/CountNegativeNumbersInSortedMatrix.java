package leetcode.p1351_count_negative_numbers_in_sorted_matrix;

public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        int[] arr1 = {3,2,0,-1};
        int[] arr2 = {2,0,-3, -4};
        int[] arr3 = {3,1,-1,-2};
        int[][] array = new int[3][4];
        array[0] = arr1;
        array[1] = arr2;
        array[2] = arr3;
        System.out.println(countNegatives(array));
    }

    public static int countNegatives(int[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
