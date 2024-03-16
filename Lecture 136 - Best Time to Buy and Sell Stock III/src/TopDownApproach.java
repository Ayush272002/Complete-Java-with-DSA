import java.util.Arrays;

class TopDownApproach
{
    private int solve(int index, int buy, int[] prices, int limit, int[][][] dp)
    {
        if(index == prices.length) return 0;
        if(limit == 0) return 0;
        if(dp[index][buy][limit] != -1) return dp[index][buy][limit];

        int profit = 0;
        if(buy == 1)
        {
            int buyNow =  -prices[index] + solve(index+1, 0, prices, limit, dp);
            int skip = solve(index + 1, 1, prices, limit, dp);
            profit = Math.max(buyNow,skip);
        }
        else
        {
            int sellNow = prices[index] + solve(index+1, 1, prices, limit-1, dp);
            int skip = solve(index + 1, 0, prices, limit, dp);
            profit = Math.max(sellNow, skip);
        }

        return dp[index][buy][limit] = profit;
    }
    public int maxProfit(int[] prices)
    {
        int[][][] dp = new int[prices.length][2][3];
        Arrays.stream(dp).forEach(matrix2D -> Arrays.stream(matrix2D).forEach(matrix1D -> Arrays.fill(matrix1D, -1)));
        return solve(0,1,prices, 2, dp);
    }
}