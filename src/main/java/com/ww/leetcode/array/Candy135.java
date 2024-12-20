package com.ww.leetcode.array;

import java.util.Arrays;

/**
 * @since 2024/12/18 17:30
 * 初始化每个孩子的糖果数量为1
 * 正序遍历，如果孩子i+1的rate大于孩子i的rate，给孩子i+1的糖果数=现在孩子i的糖果数+1；如果孩子i+1的rate小于等于孩子i的rate，不处理；
 * 倒序遍历，如果孩子i-1的rate大于孩子i的rate，给孩子i-1的糖果数=Max(孩子i-1的糖果数，现在孩子i的糖果数+1)；如果孩子i-11的rate小于等于孩子i的rate，不处理；
 */
public class Candy135 {

    public int candy(int[] ratings) {

        if (null == ratings || 0 == ratings.length) {
            return 0;
        } else {
            int[] candys = new int[ratings.length];
            Arrays.fill(candys, 1);

            for (int i = 0; i < ratings.length - 1; i++) {
                if (ratings[i+1] > ratings[i]) {
                    candys[i+1] = candys[i] + 1;
                }
            }

            for (int i = ratings.length - 1; i > 0; i--) {
                if (ratings[i-1] > ratings[i]) {
                    candys[i-1] = Math.max(candys[i-1], candys[i] + 1);
                }
            }

            int sum = 0;
            for (int i = 0; i < candys.length; i++) {
                sum += candys[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] ratings = {1, 3, 4, 5, 2};
        Candy135 candy135 = new Candy135();
        int sum = candy135.candy(ratings);
        System.out.println(sum);
    }
}
