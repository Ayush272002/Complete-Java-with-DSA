class BottomUpApproach
{
    private int solve(int[] prices)
    {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for (int index = n-1; index >= 0; index--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                for (int limit = 1; limit <= 2; limit++)
                {
                    int profit = 0;
                    if(buy == 1)
                    {
                        int buyNow =  -prices[index] + dp[index+1][0][limit];
                        int skip = dp[index+1][1][limit];
                        profit = Math.max(buyNow,skip);
                    }
                    else
                    {
                        int sellNow = prices[index] + dp[index+1][1][limit-1];
                        int skip = dp[index+1][0][limit];
                        profit = Math.max(sellNow, skip);
                    }

                    dp[index][buy][limit] = profit;
                }
            }
        }

        return dp[0][1][2];
    }
    public int maxProfit(int[] prices)
    {
        return solve(prices);
    }
}