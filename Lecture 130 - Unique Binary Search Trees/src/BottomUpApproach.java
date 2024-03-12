class BottomUpApproach
{
    private int solve(int n)
    {
        int[] dp = new int[n+1];

        dp[0] = dp[1] = 1;

        // i -> no. of nodes
        for (int i = 2; i <= n; i++)
        {
            //j -> root node
            for (int j = 1; j <= i; j++)
            {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
    public int numTrees(int n)
    {
        return solve(n);
    }
}