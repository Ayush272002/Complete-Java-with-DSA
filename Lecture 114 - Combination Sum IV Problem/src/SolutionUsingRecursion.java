class SolutionUsingRecursion
{
    private int solve(int[] nums, int target)
    {
        //base case
        if(target < 0) return 0;
        if(target == 0) return 1;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += solve(nums,target-nums[i]);
        }

        return sum;
    }
    public int combinationSum4(int[] nums, int target)
    {
        return solve(nums, target);
    }
}