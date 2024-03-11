class SolutionUsingRecursion
{
    boolean solve(int index, int[] nums, int n, int target)
    {
        //base case
        if(index >= n) return false;
        if(target < 0) return false;
        if(target == 0) return true;

        //include
        boolean include = solve(index+1, nums, n, target-nums[index]);

        //exclude
        boolean exclude = solve(index+1, nums, n, target);

        return include || exclude;
    }
    public boolean canPartition(int[] nums)
    {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        if(total % 2 !=  0) return false;
        return solve(0,nums,nums.length, total/2);
    }
}