import java.util.Arrays;

class BottomUpApproach {
    private int solve(int[] coins, int x)
    {
        int[] dp = new int[x+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        //base case
        dp[0] = 0;

        //dp[i] represents min no. of coins require to make target equal to i

        for(int i = 1; i<= x; i++)
        {
            //trying to solve for every amount figure from 1 to x
            for (int j = 0; j < coins.length; j++)
            {
                if(i-coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE)
                {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[x];
    }
    public int coinChange(int[] coins, int amount)
    {

        int ans = solve(coins,amount);
        if(ans != Integer.MAX_VALUE) return ans;
        else return -1;

    }
}

/*
TC - O(n * m), where n is the number of coins and m is the target amount.
SC - O(m+n)
*/