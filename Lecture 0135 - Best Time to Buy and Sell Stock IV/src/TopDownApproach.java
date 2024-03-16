import java.util.Arrays;

class TopDownApproach
{
    private int solve(int index, int operation, int k, int[] prices, int[][] dp)
    {
        if(index == prices.length) return 0;
        if(operation == 2*k) return 0;
        if(dp[index][operation] != -1) return dp[index][operation];

        int profit = 0;
        if(operation%2 == 0)
        {
            //buy allowed
            int buyNow =  -prices[index] + solve(index+1, operation+1,k,prices, dp);
            int skip = solve(index+1, operation, k, prices, dp);
            profit = Math.max(buyNow,skip);
        }
        else
        {
            int sellNow = prices[index] + solve(index+1, operation+1, k, prices, dp);
            int skip = solve(index+1, operation, k, prices, dp);
            profit = Math.max(sellNow, skip);
        }
        return dp[index][operation] = profit;
    }
    public int maxProfit(int k, int[] prices)
    {
        int[][] dp = new int[prices.length][2*k];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(0,0,k,prices, dp);
    }
}