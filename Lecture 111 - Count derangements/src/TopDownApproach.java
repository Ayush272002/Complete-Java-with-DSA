import java.util.Arrays;

public class TopDownApproach
{
    static long solve(int n, long[] dp)
    {
        //base case
        if(n==1) return 0;
        if(n==2) return 1;
        if(dp[n] != -1) return dp[n];

        dp[n] = ((n-1) * (solve(n-1, dp)%1000000007 + solve(n-2, dp)%1000000007))%1000000007;

        return dp[n];
    }
    public static long countDerangements(int n) {
        // Write your code here.
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1L);

        return solve(n,dp);
    }
}