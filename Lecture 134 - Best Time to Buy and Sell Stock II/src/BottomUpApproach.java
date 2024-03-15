class BottomUpApproach
{
    private int solve(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for (int index = n-1; index >= 0; index--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                int profit = 0;
                if(buy == 1)
                {
                    int buyNow =  -prices[index] + dp[index+1][0];
                    int skip = dp[index+1][1];
                    profit = Math.max(buyNow,skip);
                }
                else
                {
                    int sellNow = prices[index] + dp[index+1][1];
                    int skip = dp[index+1][0];
                    profit = Math.max(sellNow, skip);
                }

                dp[index][buy] = profit;
            }
        }

        return dp[0][1];
    }
    public int maxProfit(int[] prices)
    {
        return solve(prices);
    }
}