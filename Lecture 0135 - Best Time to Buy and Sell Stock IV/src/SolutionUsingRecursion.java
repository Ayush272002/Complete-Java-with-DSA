class SolutionUsingRecursion
{
    private int solve(int index, int operation, int k, int[] prices)
    {
        if(index == prices.length) return 0;
        if(operation == 2*k) return 0;

        int profit = 0;
        if(operation%2 == 0)
        {
            //buy allowed
            int buyNow =  -prices[index] + solve(index+1, operation+1,k,prices);
            int skip = solve(index+1, operation, k, prices);
            profit = Math.max(buyNow,skip);
        }
        else
        {
            int sellNow = prices[index] + solve(index+1, operation+1, k, prices);
            int skip = solve(index+1, operation, k, prices);
            profit = Math.max(sellNow, skip);
        }
        return profit;
    }
    public int maxProfit(int k, int[] prices)
    {

        return solve(0,0,k,prices);
    }
}