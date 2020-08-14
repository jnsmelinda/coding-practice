package hackerrank.staircase;

public class StairCase {
    public static void main(String[] args) {
        stairCase(6);
    }

    public static void stairCase(int n) {
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                if (n-j > i + 1) {
                    line += " ";
                }
                else {
                    line += "#";
                }
            }
            System.out.println(line);
        }
    }
}
