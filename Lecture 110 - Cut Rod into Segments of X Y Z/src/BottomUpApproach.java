import java.util.Arrays;

public class BottomUpApproach {
    private static int solve(int n, int x, int y, int z)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            if(i-x >= 0 && dp[i-x] != Integer.MIN_VALUE) dp[i] = Math.max(dp[i], dp[i-x]+1);
            if(i-y >= 0 && dp[i-y] != Integer.MIN_VALUE) dp[i] = Math.max(dp[i], dp[i-y]+1);
            if(i-z >= 0 && dp[i-z] != Integer.MIN_VALUE) dp[i] = Math.max(dp[i], dp[i-z]+1);
        }

        return Math.max(dp[n], 0);
    }
    public static int cutSegments(int n, int x, int y, int z)
    {
        // Write your code here.
        int ans = solve(n,x,y,z);
        return Math.max(ans, 0);
    }
}