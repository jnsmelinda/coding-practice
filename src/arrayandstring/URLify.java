package arrayandstring;

public class URLify {
    public static String URLify(String str) {
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
        return sb.toString();
    }

//    Original solution from the book.
    public static void URLify2(char[] str, int trueLength) {
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

    public static void main(String[] args){
        String words[] = {"efv dyd  fdv", "acv gtd    jg           hhffd"};
        for (String word : words) {
            System.out.println("original:" + word + "\n URL: " + URLify(word));
        }
    }
}
