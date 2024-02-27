public class BottomUpApproach {
    public static long countDerangements(int n)
    {
        // Write your code here.

        long[] dp = new long[n+1];


        //base case
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++)
        {
            long first = dp[i-1] %1000000007;
            long second = dp[i-2] %1000000007;

            long sum = (first + second) %1000000007;

            long ans = ((i-1) * sum) %1000000007;

            dp[i] = ans;
        }

        return dp[n];
    }
}