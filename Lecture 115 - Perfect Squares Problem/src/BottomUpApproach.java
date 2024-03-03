import java.util.Arrays;

class BottomUpApproach {
    private int solve(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        //base case
        dp[0] = 0;
        for(int i = 1; i<= n; i++)
        {
            int sq = 1;
            while((sq*sq)<=i)
            {
                dp[i] = Math.min(dp[i], 1+ dp[i-(sq*sq)]);
                sq++;
            }
        }

        return dp[n];
    }
    public int numSquares(int n)
    {
        int ans = solve(n);
        return ans;
    }
}