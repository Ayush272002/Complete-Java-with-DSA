class BottomUpApproach
{
    private boolean solve(int[] nums, int n, int target)
    {
        boolean[][] dp = new boolean[n+1][target+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int index = n-1; index >= 0; index--)
        {
            for(int t = 0; t <= target; t++)
            {
                //include
                boolean include = false;
                if(t-nums[index] >= 0) include = dp[index+1][t - nums[index]];

                //exclude
                boolean exclude = dp[index+1][t];

                dp[index][t] = include || exclude;
            }
        }

        return dp[0][target];
    }
    public boolean canPartition(int[] nums)
    {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        if(total % 2 !=  0) return false;
        return solve(nums, nums.length, total/2);
    }
}