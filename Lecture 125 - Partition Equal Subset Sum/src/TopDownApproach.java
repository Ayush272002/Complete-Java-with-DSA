class TopDownApproach
{
    boolean solve(int index, int[] nums, int n, int target, Boolean[][] dp)
    {
        //base case
        if(index >= n) return false;
        if(target < 0) return false;
        if(target == 0) return true;
        if(dp[index][target] != null) return dp[index][target];

        //include
        boolean include = solve(index+1, nums, n, target-nums[index], dp);

        //exclude
        boolean exclude = solve(index+1, nums, n, target, dp);

        dp[index][target] = include || exclude;
        return dp[index][target];
    }
    public boolean canPartition(int[] nums)
    {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        if(total % 2 !=  0) return false;

        Boolean[][] dp = new Boolean[nums.length][total/2 +1];
        //reason for Boolean and not boolean is that it will be initialised with null and boolean will be initialised with false.
        return solve(0,nums,nums.length, total/2, dp);
    }
}