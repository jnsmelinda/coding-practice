package leetcode.p394_decode_string;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (s.charAt(i) == '[') {
                int j = i + 1;
                int ctr = 1;
                while (ctr != 0) {
                    char c = s.charAt(j);
                    if (s.charAt(j) == '[') {
                        ctr++;
                    }
                    if (s.charAt(j) == ']') {
                        ctr--;
                    }
                    if (ctr != 0) {
                        j++;
                    }
                }

                String sub = decodeString(s.substring(i + 1, j));
                for(int k = 0; k < num; k++) {
                    sb.append(sub);
                }

                i = j;
                num = 0;
            }
        }

        return sb.toString();
    }
}
