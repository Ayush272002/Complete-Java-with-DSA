class Solution
{
    private int solve(int[] prices, int fee)
    {
        int n = prices.length;

        int[] curr = new int[2];
        int[] next = new int[2];

        for (int index = n-1; index >= 0; index--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                int profit = 0;
                if(buy == 1)
                {
                    int buyNow =  -prices[index] + next[0];
                    int skip = next[1];
                    profit = Math.max(buyNow,skip);
                }
                else
                {
                    int sellNow = prices[index] + next[1] - fee;
                    int skip = next[0];
                    profit = Math.max(sellNow, skip);
                }

                curr[buy] = profit;
            }

            System.arraycopy(curr,0,next,0,2);
        }

        return next[1];
    }
    public int maxProfit(int[] prices, int fee)
    {
        return solve(prices,fee);
    }
}

//solution based on optimal solution generated in buy and sell 2