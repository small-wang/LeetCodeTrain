package com.ww.leetcode.stack;

import java.util.Stack;

/**
 * @since 2025/1/22 15:30
 */
public class EvaluateReversePolishNotation150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer first;
        Integer second;

        for (String str : tokens) {
            switch (str) {
                case "+":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first + second);
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                case "*":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first * second);
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.valueOf(str));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation150().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
