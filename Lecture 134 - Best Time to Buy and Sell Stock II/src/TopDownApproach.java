import java.util.Arrays;

class TopDownApproach
{
    private int solve(int index, int buy, int[] prices, int[][] dp)
    {
        if(index == prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 1)
        {
            int buyNow =  -prices[index] + solve(index+1, 0, prices, dp);
            int skip = solve(index + 1, 1, prices, dp);
            profit = Math.max(buyNow,skip);
        }
        else
        {
            int sellNow = prices[index] + solve(index+1, 1, prices, dp);
            int skip = solve(index + 1, 0, prices, dp);
            profit = Math.max(sellNow, skip);
        }

        return dp[index][buy] = profit;
    }
    public int maxProfit(int[] prices)
    {
        int[][] dp = new int[prices.length][2];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(0,1,prices, dp);
    }
}