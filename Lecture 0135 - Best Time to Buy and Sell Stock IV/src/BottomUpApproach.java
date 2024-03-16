class BottomUpApproach
{
    private int solve(int k, int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k + 1];

        for (int index = n-1; index >= 0; index--)
        {
            for (int operation = 0; operation < 2*k; operation++)
            {
                int profit = 0;
                if(operation%2 == 0)
                {
                    //buy allowed
                    int buyNow =  -prices[index] + dp[index+1][operation+1];
                    int skip = dp[index+1][operation];
                    profit = Math.max(buyNow,skip);
                }
                else
                {
                    int sellNow = prices[index] + dp[index+1][operation+1];
                    int skip = dp[index+1][operation];
                    profit = Math.max(sellNow, skip);
                }
                dp[index][operation] = profit;
            }
        }

        return dp[0][0];
    }
    public int maxProfit(int k, int[] prices)
    {
        return solve(k,prices);
    }
}