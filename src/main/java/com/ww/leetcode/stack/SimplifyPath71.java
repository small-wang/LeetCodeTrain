package com.ww.leetcode.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * @since 2025/1/15 14:17
 */
public class SimplifyPath71 {

    public String simplifyPath(String path) {
        String split = "/";
        StringBuffer result = new StringBuffer();
        String[] pathSplit = path.split(split);
        Stack<String> stack = new Stack<>();

        if (null == pathSplit || 0 == pathSplit.length) {
            return split;
        }

        for (String str : pathSplit) {
            if ("".equals(str)) {
                continue;
            } else if (".".equals(str)) {
                continue;
            } else if ("..".equals(str)) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        if (stack.empty()) {
            result.append(split);
        } else {
            Iterator<String> iterator = stack.iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                result.append(split).append(str);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath71().simplifyPath("/.../a/../b/c/../d/./"));
    }
}
