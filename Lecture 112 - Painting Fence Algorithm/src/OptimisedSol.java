public class OptimisedSol {
    private static final int MOD = 1000000007;

    private static int add(int a, int b) {
        return (a % MOD + b % MOD) % MOD;
    }

    public static int numberOfWays(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;

        int prev2 = k;
        int prev1 = k * k;

        for (int i = 3; i <= n; i++) {
            // Calculate the number of ways for the current post based on the previous two posts
            int ans = mul(prev2, k - 1) + mul(prev1, k - 1);

            // Update the previous two counts for the next iteration
            prev2 = prev1;
            prev1 = ans % MOD;
        }

        return prev1;
    }

    private static int mul(int a, int b) {
        return (int) (((long) a * b) % MOD);
    }
}
