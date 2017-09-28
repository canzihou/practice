package 有效的括号序列;

import java.util.Stack;

public class Solution {
    /*
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!((aChar == ')' && pop == '(') || (aChar == ']' && pop == '[') || (aChar == '}' && pop == '{'))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
