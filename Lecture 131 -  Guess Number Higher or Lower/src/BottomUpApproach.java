class BottomUpApproach
{
    private int solve(int n)
    {
        int[][] dp = new int[n+2][n+2];

        for(int start = n; start >= 1; start--)
        {
            for(int end = start; end <= n; end++)
            {
                if(start == end) continue;
                else
                {
                    int maxi = Integer.MAX_VALUE;
                    for (int i = start; i <= end; i++) {
                        maxi = Math.min(maxi, i + Math.max(dp[start][i-1], dp[i+1][end]));
                    }

                    dp[start][end] = maxi;
                }
            }
        }

        return dp[1][n];
    }
    public int getMoneyAmount(int n)
    {
        return solve(n);
    }
}
