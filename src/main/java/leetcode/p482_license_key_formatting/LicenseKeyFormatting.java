package leetcode.p482_license_key_formatting;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting2("5F3Z-2e-9-w", 4));
    }

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();

        char[] s = S.toCharArray();

        int counter = 0;
        for (int i = s.length - 1; i >= 0; i--) {

            if (s[i] == '-') {
                continue;
            }

            if (K == counter) {
                counter = 0;
                sb.append("-");
            }

            sb.append(Character.toUpperCase(s[i]));
            counter++;
        }
        return sb.reverse().toString();
    }

    public static String licenseKeyFormatting2(String S, int K) {
        S = S.replace("-","").toUpperCase();
        StringBuilder sb = new StringBuilder(S);

        int len = S.length();
        for(int i = len - K; i > 0; i = i - K) {
            sb.insert(i,'-');
        }
        return sb.toString();
    }
}
