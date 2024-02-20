class SolutionUsingBottomUp {
    private int solve(int[] cost, int n)
    {
        //step 1 : creation of dp
        int[] dp = new int[n+1];

        //step 2: base case
        dp[0] = cost[0];
        dp[1] = cost[1];

        //3rd case
        for(int i = 2; i<n; i++)
        {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1],dp[n-2]);
    }
    public int minCostClimbingStairs(int[] cost)
    {
        int n = cost.length;

        return solve(cost,n);
    }
}

/*
TC & SC - O(n)
 */