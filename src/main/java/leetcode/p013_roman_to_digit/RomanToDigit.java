package leetcode.p013_roman_to_digit;

public class RomanToDigit {
    public static void main(String[] args) {
        String num = "MCMXCIV";
        System.out.println(romanToInt(num));
    }

    public static int romanToInt(String s) {
        int result = digit(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            int currentDigit = digit(s.charAt(i));
            int prevDigit = digit(s.charAt(i + 1));
            if (currentDigit < prevDigit) {
                result -= currentDigit;
            }
            else {
                result += currentDigit;
            }
        }

        return result;
    }

    private static int digit(char ch) {
        int digit = 0;
        switch(ch) {
            case 'I':
                digit = 1;
                break;
            case 'V':
                digit = 5;
                break;
            case 'X':
                digit = 10;
                break;
            case 'L':
                digit = 50;
                break;
            case 'C':
                digit = 100;
                break;
            case 'D':
                digit = 500;
                break;
            case 'M':
                digit = 1000;
                break;
        }

        return digit;
    }
}
