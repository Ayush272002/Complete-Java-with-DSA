class SolutionUsingRecursion {
    private int solve(int[] nums, int n)
    {
        //base cae
        if(n < 0) return 0;
        if(n == 0) return nums[0];

        int include = solve(nums, n-2) + nums[n];
        int exclude = solve(nums, n-1) + 0;

        return Math.max(include,exclude);
    }
    public int rob(int[] nums)
    {
        int n = nums.length;
        int ans = solve(nums, nums.length-1);
        return ans;
    }
}