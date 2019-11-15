package ctci.arrayandstring;

public class StringCompression {
    public static String compressor(String str) {
        StringBuilder compressed = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            counter++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
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

    public static void main(String[] args) {
        String[] words = {"aabgggcccc", "kkkghhddddlj"};
        for (String word : words) {
            System.out.println(word + ": " + compressor(word));
        }
    }
}
