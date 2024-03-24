class OptimisedSol
{
    private int solve(int k, int[] prices)
    {
        int n = prices.length;
        int[] curr = new int[2*k + 1];
        int[] next = new int[2*k + 1];

        for (int index = n-1; index >= 0; index--)
        {
            for (int operation = 0; operation < 2*k; operation++)
            {
                int profit = 0;
                if(operation%2 == 0)
                {
                    //buy allowed
                    int buyNow =  -prices[index] + next[operation+1];
                    int skip = next[operation];
                    profit = Math.max(buyNow,skip);
                }
                else
                {
                    int sellNow = prices[index] + next[operation+1];
                    int skip = next[operation];
                    profit = Math.max(sellNow, skip);
                }
                curr[operation] = profit;
            }

            System.arraycopy(curr,0,next,0,curr.length);
        }

        return next[0];
    }
    public int maxProfit(int k, int[] prices)
    {
        return solve(k,prices);
    }
}