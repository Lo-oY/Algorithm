package com.ly;

import java.util.Stack;

/**
 * Created by Lo_oY on 2016/9/4.
 */
public class BalanceChar {

    public boolean juige(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                if (isMatch(stack.peek(), str.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isMatch(char ch1, char ch2) {
        if ((ch1 == '{' && ch2 == '}') || (ch1 == '[' && ch2 == ']') || (ch1 == '(' && ch2 == ')'))
            return true;
        else
            return false;

    }

    public static void main(String args[]) {

        BalanceChar bc = new BalanceChar();
        String str = "{[]}()";
        System.out.println(bc.juige(str));
    }
}
