package ctci.recursionanddynamic;

import java.util.Arrays;

public class Colours {

    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                          {1, 1, 1, 1, 1, 1, 0, 0},
                          {1, 0, 0, 1, 1, 0, 1, 1},
                          {1, 2, 2, 2, 2, 0, 1, 0},
                          {1, 1, 1, 2, 2, 0, 1, 0},
                          {1, 1, 1, 2, 2, 2, 2, 0},
                          {1, 1, 1, 1, 1, 2, 1, 1},
                          {1, 1, 1, 1, 1, 2, 2, 1}};

        for (int i = 0; i < screen.length; i++) {
            System.out.println(Arrays.toString(screen[i]));
        }
        System.out.println("---------------------------------------------------");
        fill(screen, 4, 4, 3);
        for (int i = 0; i < screen.length; i++) {
            System.out.println(Arrays.toString(screen[i]));
        }
    }

    private static void fill(int[][] screen, int r, int c, int newColor) {
        int prevColor = screen[r][c];
        colorUntil(screen, r, c, newColor, prevColor);
    }

    private static void colorUntil(int[][] screen, int r, int c, int newColor, int prevColor) {
        if (r < 0 || r > screen.length - 1 || c < 0 || c > screen[0].length - 1) {
            return;
        }
        if (screen[r][c] != prevColor) {
            return;
        }
        else {
            screen[r][c] = newColor;
            colorUntil(screen, r - 1 , c, newColor, prevColor);
            colorUntil(screen, r + 1, c, newColor, prevColor);
            colorUntil(screen, r, c - 1, newColor, prevColor);
            colorUntil(screen, r, c + 1, newColor, prevColor);
        }
    }

}
