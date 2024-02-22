class OptimisedSol {
    private int solve(int[] nums, int n)
    {
        int prev2 = nums[0];
        int prev1 = Math.max(prev2,nums[1]);

        for (int i = 2; i < n; i++) {
            int include = prev2 + nums[i];
            int exclude = prev1;
            int ans = Math.max(include, exclude);

            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
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