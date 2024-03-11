import java.util.Arrays;

class TopDownApproach
{
    private int solve(int dice, int faces, int target, int[][] dp)
    {
        //base case
        if(target < 0) return 0;
        if(dice == 0 && target != 0) return 0;
        if(target ==0 && dice != 0) return 0;
        if(dice == 0 && target == 0) return 1;
        if(dp[dice][target] != -1) return dp[dice][target];


        int ans= 0;
        for (int i = 1; i <= faces; i++) {
            ans += solve(dice-1, faces, target-i, dp);
            ans %= 1000000007;
        }

        dp[dice][target] = ans;
        return dp[dice][target];
    }
    public int numRollsToTarget(int n, int k, int target)
    {
        int[][] dp = new int[n+1][target+1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(n, k, target, dp);
    }
}