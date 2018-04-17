package thinkingInJava;

import java.util.Stack;

public class Temp {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String string = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+r+u--+l+e+s---";
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                stack.push(chars[++i]);
            } else {
                System.out.print(stack.pop());
            }
        }
    }
}
