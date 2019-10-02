package arrayandstring;

public class IsUnique {

    public static boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    public static boolean isUnique2(String str){
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((check & (1 << val)) > 0){
                return false;
            }
            check |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "hippo", "table", "chair"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
            System.out.println(word + ": " + isUnique2(word));
        }
    }

}
