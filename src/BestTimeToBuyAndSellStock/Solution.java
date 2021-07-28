package BestTimeToBuyAndSellStock;


// Time Complexity: O(n);
// Link to problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {

        int buyIndex = 0;

        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < prices[buyIndex]) {
                buyIndex = i;
            }


            if (prices[i] - prices[buyIndex] > profit) {
                profit = prices[i] - prices[buyIndex];
            }

        }

        return profit;

    }
}