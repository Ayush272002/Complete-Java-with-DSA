class RecursiveSolution {
    private int solve(int[] coins, int x)
    {
        //base case
        if(x == 0) return 0;
        if(x < 0) return Integer.MAX_VALUE;

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solve(coins, x-coins[i]);
            if(ans != Integer.MAX_VALUE) mini = Math.min(mini, 1+ans);
        }

        return mini;
    }
    public int coinChange(int[] coins, int amount)
    {
        int ans = solve(coins,amount);
        if(ans != Integer.MAX_VALUE) return ans;
        else return -1;
    }
}

/*
TC - O(n^m), where n is the number of coins and m is the target amount.
SC - O(m)
 */