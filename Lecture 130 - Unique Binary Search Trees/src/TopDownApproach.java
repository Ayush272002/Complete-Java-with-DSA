import java.util.Arrays;

class TopDownApproach
{
    private int solve(int n, int[] dp)
    {
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];

        int ans = 0;//think i as root nodes
        for (int i = 1; i <= n; i++) {
            ans += solve(i-1, dp) * solve(n-i, dp);
        }

        dp[n] = ans;
        return dp[n];
    }
    public int numTrees(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}