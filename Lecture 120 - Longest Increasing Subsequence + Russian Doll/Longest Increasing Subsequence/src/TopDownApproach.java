import java.util.Arrays;

class TopDownApproach
{
    private int solve(int[] nums, int n, int curr, int prev, int[][] dp)
    {
        //base case
        if(curr == n) return 0;
        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];

        //include
        int include = 0;
        if(prev == -1 || nums[curr] > nums[prev])
        {
            include = 1 + solve(nums, n, curr+1, curr, dp);
        }

        //exclude
        int exclude = solve(nums, n, curr+1, prev, dp);

        dp[curr][prev+1] = Math.max(include,exclude);
        return dp[curr][prev+1];
    }
    public int lengthOfLIS(int[] nums)
    {
        int[][] dp = new int[nums.length][nums.length+1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(nums, nums.length, 0, -1, dp);
    }
}