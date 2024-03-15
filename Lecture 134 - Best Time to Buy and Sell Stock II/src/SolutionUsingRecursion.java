class SolutionUsingRecursion
{
    private int solve(int index, int buy, int[] prices)
    {
        if(index == prices.length) return 0;

        int profit = 0;
        if(buy == 1)
        {
            int buyNow =  -prices[index] + solve(index+1, 0, prices);
            int skip = solve(index + 1, 1, prices);
            profit = Math.max(buyNow,skip);
        }
        else
        {
            int sellNow = prices[index] + solve(index+1, 1, prices);
            int skip = solve(index + 1, 0, prices);
            profit = Math.max(sellNow, skip);
        }

        return profit;
    }
    public int maxProfit(int[] prices)
    {
        return solve(0,1,prices);
    }
}