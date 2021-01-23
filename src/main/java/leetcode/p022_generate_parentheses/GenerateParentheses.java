package leetcode.p022_generate_parentheses;
import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        solve(3, 3, "", result);
        return result;
    }

    public static void solve(int open, int closed, String currentString, List<String> result) {
        if (open == 0 && closed == 0) {
            result.add(currentString);
            return;
        }

        if (open > 0) {
            String output1 = currentString;
            output1 = currentString + "(";
            solve(open -1 , closed, output1, result);

        }
        if (closed > open) {
            String output1 = currentString;
            output1 = currentString + ")";
            solve(open, closed -1 , output1, result);
        }
    }
}
