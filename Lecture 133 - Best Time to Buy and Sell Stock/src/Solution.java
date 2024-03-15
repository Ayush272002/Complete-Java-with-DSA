class Solution {
    public int maxProfit(int[] prices)
    {
        int n = prices.length;

        if(n == 0) return 0;
        int mini = prices[0];
        int profit = 0;

        for (int i = 1; i < n; i++) {
            int diff = prices[i] - mini;
            profit = Math.max(profit,diff);
            mini = Math.min(mini, prices[i]);
        }

        return profit;
    }
}