import java.util.Arrays;

public class TopDownApproach {
    private static int solve(int n, int x, int y, int z,int[] dp)
    {
        //base case
        if(n == 0) return 0;
        if(n < 0) return Integer.MIN_VALUE;
        if(dp[n] != -1) return dp[n];

        int a = solve(n-x,x,y,z,dp) + 1;
        int b = solve(n-y,x,y,z,dp) + 1;
        int c = solve(n-z, x, y,z,dp) + 1;

        dp[n] = Math.max(a,Math.max(b,c));
        return dp[n];
    }
    public static int cutSegments(int n, int x, int y, int z)
    {
        // Write your code here.
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        int ans = solve(n,x,y,z,dp);
        return Math.max(ans, 0);
    }
}