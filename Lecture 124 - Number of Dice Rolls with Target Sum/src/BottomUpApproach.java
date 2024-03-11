class BottomUpApproach
{
    private int solve(int d, int f, int t)
    {
        int[][] dp = new int[d+1][t+1];

        //base cases
        dp[0][0] = 1;

        for(int dice = 1; dice <= d; dice++)
        {
            for(int target = 1; target <= t; target++)
            {
                int ans= 0;
                for (int faces = 1; faces <= f; faces++)
                {
                    if(target - faces >= 0)
                    {
                        ans += dp[dice-1][target-faces];
                        ans %= 1000000007;
                    }
                }
                dp[dice][target] = ans;
            }
        }

        return dp[d][t];
    }
    public int numRollsToTarget(int n, int k, int target)
    {
        return solve(n,k,target);
    }
}