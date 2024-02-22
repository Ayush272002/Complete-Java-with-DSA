import java.util.Arrays;

class TopDownApproach {
    private int solve(int[] nums, int n, int[] dp)
    {
        //base cae
        if(n < 0) return 0;
        if(n == 0) return nums[0];
        if(dp[n] != -1) return dp[n];

        int include = solve(nums, n-2, dp) + nums[n];
        int exclude = solve(nums, n-1, dp) + 0;

        dp[n] = Math.max(include,exclude);
        return dp[n];
    }
    public int rob(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = solve(nums, nums.length-1, dp);
        return ans;
    }
}