public class BottomUpApproach {
    private static final int MOD = 1000000007;

    public static int numberOfWays(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;

        // dp[i] represents the number of ways to color i posts with k colors
        int[] dp = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;

        for (int i = 3; i <= n; i++) {
            // If the current post has the same color as the previous post,
            // we have (k - 1) choices for coloring the current post.
            long sameColor = (long) dp[i - 2] * (k - 1) % MOD;

            // If the current post has a different color from the previous post,
            // we have (k - 1) choices for coloring the current post.
            long diffColor = (long) dp[i - 1] * (k - 1) % MOD;

            // Total number of ways to color the current post
            dp[i] = (int) ((sameColor + diffColor) % MOD);
        }

        return dp[n];
    }
}
