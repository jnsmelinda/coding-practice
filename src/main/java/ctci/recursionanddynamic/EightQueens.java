package ctci.recursionanddynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueens {

    private static final int GRID_SIZE = 8;

    public static void main(String[] args) {
        ArrayList<Integer[]> queens = new ArrayList<>();
        eightQueens(queens, 0, new Integer[GRID_SIZE]);

        System.out.println(queens.size());
        for (Integer[] array : queens) {
            System.out.println(Arrays.deepToString(array));
            System.out.println("------------------------------------------");
        }
    }

    public static void eightQueens(ArrayList<Integer[]> queens, int row, Integer[] column) {
        if (row == GRID_SIZE) {
            queens.add(column.clone());
        }
        else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (safe(column, row, col)) {
                    column[row] = col;
                    eightQueens(queens, row + 1, column);
                }
            }
        }
    }

    private static boolean safe(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            if (column1 == column2 || Math.abs(column2 - column1) == Math.abs(row1 - row2)) {
                return false;
            }
        }
        return true;
    }
}
