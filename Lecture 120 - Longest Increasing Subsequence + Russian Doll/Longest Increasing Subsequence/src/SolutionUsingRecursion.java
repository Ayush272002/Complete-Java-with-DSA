class SolutionUsingRecursion
{
    private int solve(int[] nums, int n, int curr, int prev)
    {
        //base case
        if(curr == n) return 0;

        //include
        int include = 0;
        if(prev == -1 || nums[curr] > nums[prev])
        {
            include = 1 + solve(nums, n, curr+1, curr);
        }

        //exclude
        int exclude = solve(nums, n, curr+1, prev);

        return Math.max(include,exclude);
    }
    public int lengthOfLIS(int[] nums)
    {
        return solve(nums, nums.length, 0, -1);
    }
}