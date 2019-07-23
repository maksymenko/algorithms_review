package com.sm.misc_4.dp;

public class BestStockProfit {
    public int max(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }

    public static void main(String[] args) {
        BestStockProfit bsp = new BestStockProfit();
        System.out.println(">>>> expected 5:  " + bsp.max(new int[]{7,1,5,3,6,4}));
        System.out.println(">>>> expected 0:  " + bsp.max(new int[]{7,6,4,3,1}));

    }
}
