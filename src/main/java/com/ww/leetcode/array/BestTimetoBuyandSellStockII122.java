package com.ww.leetcode.array;

/**
 * @since 2023/11/23 9:34
 */
public class BestTimetoBuyandSellStockII122 {

    public int maxProfit(int[] prices) {
        int max = 0;
        int sell = 0;
        int buy = 1;
        while (buy < prices.length) {
            if (prices[buy] > prices[sell]) {
                max += prices[buy] - prices[sell];
            }
            sell++;
            buy++;
        }

        return max;
    }


    public static void main(String[] args) {
        BestTimetoBuyandSellStockII122 bestTimetoBuyandSellStockII122 = new BestTimetoBuyandSellStockII122();
        int[] prices = {7,1,5,3,6,4};

        int result = bestTimetoBuyandSellStockII122.maxProfit(prices);
        System.out.println(result);
    }
}
