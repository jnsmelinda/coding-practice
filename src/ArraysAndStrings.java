import java.util.HashMap;
import java.util.Map;

public class ArraysAndStrings {
    public static void main(String[] args) {
//        String str = "efv dyd  fdv";
//        replace2(str.toCharArray(), str.length());
//        replace(str);
//        isPermutationOfPalindrome("tacc     at");
//        isOneEditAway("abc", "abdc");
//        System.out.println(compressor("aaabgggcccc"));
        int[][] arr = {{1,2,3,4},{4,5,6,7}, {7,8,9,10}, {3,3,3,3}};
        printMatrix(arr);
        rotate(arr);
        System.out.println("---------------------------------");
        printMatrix(arr);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 100){
                    System.out.print(matrix[i][j] + "  ");
                }
                else if (matrix[i][j] < 10){
                    System.out.println(matrix[i][j] + "   ");
                }

            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < ((n + 1) / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static String compressor(String str) {
        StringBuilder compressed = new StringBuilder();
        int counter = 0;

        for (int i = 1; i < str.length(); i++) {
            counter++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i - 1));
                compressed.append(counter);
                counter = 0;
            }
        }

        return validate(str, compressed);
    }

    private static String validate(String str, StringBuilder compressed) {
        if (compressed.length() >= str.length()) {
            return str;
        } else {
            return compressed.toString();
        }
    }

    public static boolean isOneEditAway(String str1, String str2) {
        if (str1.length() == str2.length()) {
            int counter = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    counter++;
                }
            }
            if (counter == 1) {
                return true;
            }
        } else {
            if (str1.length() + 1 == str2.length()) {
                String longer = str2;
                String shorter = str1;
                for (int i = 0; i < shorter.length(); i++) {
                    if (shorter.charAt(i) != longer.charAt(i)) {
                        int index = longer.indexOf(longer.charAt(i));
                        if (shorter.indexOf(shorter.charAt(i)) == index + 1) {
                            return true;
                        }
                    }
                }
            } else if (str1.length() - 1 == str2.length()) {

            }
        }

        return false;
    }

    public static boolean isPermutationOfPalindrome(String str) {
        Map<Character, Integer> frequencies = getFrequencies(str);

        if (countOddValues(frequencies) > 1) {
            return false;
        }
        return true;
    }

    private static int countOddValues(Map<Character, Integer> frequencies) {
        int odds = 0;
        for (Integer value : frequencies.values()) {
            if (value % 2 != 0) {
                odds++;
            }
        }
        return odds;
    }

    private static Map getFrequencies(String str) {
        Map<Character, Integer> frequencies = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (ch != ' ') {
                if (frequencies.containsKey(ch)) {
                    frequencies.put(ch, frequencies.get(ch) + 1);
                } else {
                    frequencies.put(ch, 1);
                }
            }
        }

        return frequencies;
    }

    public static void replace(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
                while (str.charAt(i) == ' ') {
                    i++;
                }
            }
            sb.append(str.charAt(i));
        }
        str = sb.toString();
    }

    public static void replace2(char[] str, int trueLength) {
        int spaceCount = count(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + spaceCount * 2;

        if (newIndex + 1 < str.length) {
            str[newIndex + 1] = '\0';
        }

        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
            if (str[oldIndex] == ' ') {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex -= 1;
            }
        }
    }

    private static int count(char[] strArr, int start, int end, int target) {
        int counter = 0;
        for (int i = start; i < end; i++) {
            if (strArr[i] == target) {
                counter++;
            }
        }
        return counter;
    }

}
