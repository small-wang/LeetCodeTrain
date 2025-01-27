package com.ww.leetcode.topInter150.stack;

import java.util.Stack;

/**
 * @since 2025/1/21 10:13
 */
public class MinStack155 {

    private Stack<Integer> stack;
    private Integer minVal;

    public  MinStack155() {
        this.stack = new Stack<>();
        this.minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        this.stack.push(val);
        if (val < minVal) {
            this.minVal = Integer.MAX_VALUE;
        }
    }

    public void pop() {
        Integer popVal = this.stack.pop();
        if (minVal.equals(popVal)) {
            minVal = Integer.MAX_VALUE;
        }
    }

    public int top() {
        Integer topVal = this.stack.peek();
        return topVal;
    }

    public int getMin() {
        if (minVal == Integer.MAX_VALUE) {
            for (Integer val : stack) {
                if (val < this.minVal) {
                    this.minVal = val;
                }
            }
        }

        return minVal;
    }

    public static void main(String[] args) {

    }
}
