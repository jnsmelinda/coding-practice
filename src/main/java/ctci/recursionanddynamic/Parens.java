package ctci.recursionanddynamic;

import java.util.ArrayList;

public class Parens {
    public static void main(String[] args) {
        System.out.println(parens(3));
    }

    public static ArrayList<String> parens(int n) {
        ArrayList result = new ArrayList();
        StringBuilder str = new StringBuilder();
        str.setLength(n * 2);
        parens(result, n, n, str);
        return result;
    }

    private static void parens(ArrayList<String> list, int left, int right, StringBuilder str) {
        if (left < 0 || right < left) {
            return;
        }
        if (left == right && left == 0) {
            list.add(str.toString());
        }
        else {
            str.setCharAt(str.length() - (left + right), '(');
//            str[str.length - (left + right)] = '(';
            parens(list, left - 1, right, str);

            str.setCharAt(str.length() - (left + right), ')');
//            str[str.length - (left + right)] = ')';
            parens(list, left, right - 1, str);
        }
    }
}
