class OptimalSolBasedOnPart3OfThisQues
{
    private int solve(int[] prices, int k)
    {
        int n = prices.length;

        int[][] curr = new int[2][k+1];
        int[][] next = new int[2][k+1];

        for (int index = n-1; index >= 0; index--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                for (int limit = 1; limit <= k; limit++)
                {
                    int profit = 0;
                    if(buy == 1)
                    {
                        int buyNow =  -prices[index] + next[0][limit];
                        int skip = next[1][limit];
                        profit = Math.max(buyNow,skip);
                    }
                    else
                    {
                        int sellNow = prices[index] + next[1][limit-1];
                        int skip = next[0][limit];
                        profit = Math.max(sellNow, skip);
                    }

                    curr[buy][limit] = profit;
                }
            }

            System.arraycopy(curr,0,next,0,curr.length);
        }

        return next[1][k];
    }
    public int maxProfit(int k, int[] prices)
    {
        return solve(prices,k);
    }
}