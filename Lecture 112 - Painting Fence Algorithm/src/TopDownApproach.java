import java.util.Arrays;

public class TopDownApproach {
    private static final int MOD = 1000000007;

    private static long add(long a, long b) {
        return (a + b) % MOD;
    }

    private static long mul(long a, long b) {
        return (a * b) % MOD;
    }

    private static int solve(int n, int k, long[] dp) {
        // base case
        if (n == 1) return k;
        if (n == 2) return (int)mul(k, k);

        if (dp[n] != -1) return (int)dp[n];

        // If the current post has the same color as the previous post
        long sameColor = mul(solve(n - 2, k, dp), k - 1);

        // If the current post has a different color from the previous post
        long diffColor = mul(solve(n - 1, k, dp), k - 1);

        dp[n] = add(sameColor, diffColor);
        return (int)dp[n];
    }

    public static int numberOfWays(int n, int k) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, k, dp);
    }
}
