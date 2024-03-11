public class BottomUpApproach
{
    private int solve(int[] nums)
    {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for (int curr = n-1; curr >= 0 ; curr--)
        {
            for (int prev = curr-1; prev >= -1; prev--)
            {
                //include
                int include = 0;
                if(prev == -1 || nums[curr] > nums[prev])
                {
                    include = 1 + dp[curr+1][curr+1];
                }

                //exclude
                int exclude = dp[curr+1][prev+1];

                dp[curr][prev+1] = Math.max(include,exclude);
            }
        }

        return dp[0][0];
    }
    public int lengthOfLIS(int[] nums)
    {
        return solve(nums);
    }
}
