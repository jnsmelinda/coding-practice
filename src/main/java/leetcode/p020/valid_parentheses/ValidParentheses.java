package leetcode.p020.valid_parentheses;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{}"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for(char ch : chars) {
            if(ch == '}') {
                if(stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if(ch == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else if(ch == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
