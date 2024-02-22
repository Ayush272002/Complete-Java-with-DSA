import java.util.Arrays;

class TopDownApproach {
    private int solve(int[] coins, int x, int[] dp)
    {
        //base case
        if(x == 0) return 0;
        if(x < 0) return Integer.MAX_VALUE;
        if(dp[x] != -1) return dp[x];

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++)
        {
            int ans = solve(coins, x-coins[i],dp);
            if(ans != Integer.MAX_VALUE) mini = Math.min(mini, 1+ans);
        }

        dp[x] = mini;

        return mini;
    }
    public int coinChange(int[] coins, int amount)
    {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = solve(coins,amount,dp);
        if(ans != Integer.MAX_VALUE) return ans;
        else return -1;

    }
}


/*
TC - O(n * m), where n is the number of coins and m is the target amount.
SC - O(m+n)
*/
