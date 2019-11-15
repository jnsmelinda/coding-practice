package ctci.arrayandstring;

public class StringRotation {
    public static boolean isRotation(String str1, String str2){
        int len = str1.length();
        if (len == str2.length() && len > 0){
            String str1str1 = str1 + str1;
            return isSubstring(str1str1, str2);
        }
        return false;
    }

    public static boolean isSubstring(String str1, String str2) {
        return str1.indexOf(str2) >= 0;
    }

    public static void main(String[] args) {
        String szo = "abc";
        String szo2 = "bca";
        System.out.println(isRotation(szo,szo2));
    }
}
