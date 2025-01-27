package com.ww.leetcode.topInter150.arrayAndString;

/**
 * @since 2023/11/23 9:20
 */
public class BestTimetoBuyandSellStock121 {

    public int maxProfit(int[] prices) {
        int max = 0;
        int sell = 0, buy = 0;
        while (buy < prices.length) {
            if (prices[buy] - prices[sell] >= 0) {
                max = max > prices[buy] - prices[sell] ? max : prices[buy] - prices[sell];
            } else {
                sell = buy;
            }
            buy++;
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStock121 bestTimetoBuyandSellStock121 = new BestTimetoBuyandSellStock121();
        int[] prices = {0, 1, 2, 3, 4, 5};

        int result = bestTimetoBuyandSellStock121.maxProfit(prices);
        System.out.println(result);
    }
}
