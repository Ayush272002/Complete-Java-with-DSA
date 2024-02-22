class BottomUpApproach {
    private int solve(int[] nums, int n)
    {
        //step 1 : dp creation
        int[] dp = new int[n];

        //base cae
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);

        for (int i = 2; i < n; i++) {
            int include = dp[i-2] + nums[i];
            int exclude = dp[i-1] + 0;

            dp[i] = Math.max(include,exclude);
        }

        return dp[n-1];
    }
    public int rob(int[] nums)
    {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int ans = solve(nums, n);
        return ans;
    }
}