package com.ww.leetcode.topInter150.dpMultidimensional;

import java.util.LinkedList;
import java.util.List;

/**
 * @since 2025/2/24 16:00
 */
public class Triangle120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new LinkedList<>();

        for (int i = 0; i <= triangle.size() - 1; i++) {
            List<Integer> triangleI = triangle.get(i);
            List<Integer> dpI = new LinkedList<>();
            dp.add(dpI);

            for (int j = 0; j <= triangleI.size() - 1; j++) {
                if (i == 0) {
                    dpI.add(triangleI.get(j));
                } else {
                    if (j == 0) {
                        dpI.add(triangleI.get(j) + (dp.get(i-1).get(j)));
                    } else if (j == triangleI.size() - 1) {
                        dpI.add(triangleI.get(j) + (dp.get(i-1).get(j - 1)));
                    } else {
                        dpI.add(triangleI.get(j) + Math.min(dp.get(i-1).get(j), dp.get(i-1).get(j-1)));
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int length = dp.get(dp.size() - 1).size();
        for (int i = 0; i <= length-1; i++) {
            min = Math.min(min, dp.get(dp.size() - 1).get(i));
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        List<Integer> triangle1 = new LinkedList<>();
        List<Integer> triangle2 = new LinkedList<>();
        List<Integer> triangle3 = new LinkedList<>();
        List<Integer> triangle4 = new LinkedList<>();

        triangle.add(triangle1);
        triangle.add(triangle2);
        triangle.add(triangle3);
        triangle.add(triangle4);

        triangle1.add(2);

        triangle2.add(3);
        triangle2.add(4);

        triangle3.add(6);
        triangle3.add(5);
        triangle3.add(7);

        triangle4.add(4);
        triangle4.add(1);
        triangle4.add(8);
        triangle4.add(3);

        System.out.println(new Triangle120().minimumTotal(triangle));
    }
}
