import java.util.Arrays;

class TopDownApproach {
    private int solve(int n, int[] dp)
    {
        if(n <= 3) return n;
        if(dp[n] != -1) return dp[n];

        int sq = 1;
        while((sq*sq)<=n) sq++;

        sq--; // to get back to the true condition in the loop

        int min = Integer.MAX_VALUE;
        for(int i = sq; i>=1; i--)
        {
            int count = 1 + solve((n- (i*i)),dp);
            min = Math.min(min,count);
        }

        dp[n] = min;
        return min;
    }
    public int numSquares(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = solve(n, dp);
        return ans;
    }
}