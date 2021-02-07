package leetcode.p0292_nim_game;

public class NimGame {
    public static void main(String[] args) {
        System.out.println(canWinNim(6));
    }

    public static boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
