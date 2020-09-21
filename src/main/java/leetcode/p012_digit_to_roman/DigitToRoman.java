package leetcode.p012_digit_to_roman;

public class DigitToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int decimal = 1;
        while (num > 0) {
            int digit = num % 10;
            num = num / 10;
            System.out.println(digit);
            if ((digit + 1) == 5) {
                sb.append(roman(decimal * 5));
                sb.append(roman(decimal * 1));
            }
            else if ((digit + 1) == 10) {
                sb.append(roman(decimal * 10));
                sb.append(roman(decimal * 1));
            }
            else if (digit - 5 > 0) {
                for (int i = 0; i < digit - 5; i++) {
                    sb.append(roman(decimal * 1));
                }
                sb.append(roman(decimal * 5));
            }
            else if (digit < 5 - 1){
                for (int i = 0; i < digit; i++) {
                    sb.append(roman(decimal * 1));
                }
            } else {
                sb.append(roman(decimal * digit));
            }
            
            decimal *= 10;
        }
        sb.reverse();

        return sb.toString();
    }


    private static String roman(int digit) {
        String roman = "";
        switch(digit) {
            case 1:
                roman = "I";
                break;
            case 5:
                roman = "V";
                break;
            case 10:
                roman = "X";
                break;
            case 50:
                roman = "L";
                break;
            case 100:
                roman = "C";
                break;
            case 500:
                roman = "D";
                break;
            case 1000:
                roman = "M";
                break;
        }

        return roman;
    }
}
