class OptimisedSolution
{
    private boolean solve(int[] nums, int n, int target)
    {
        boolean[] curr = new boolean[target+1];
        boolean[] next = new boolean[target+1];

        curr[0] = true;
        next[0] = true;

        for(int index = n-1; index >= 0; index--)
        {
            for(int t = 0; t <= target; t++)
            {
                //include
                boolean include = false;
                if(t-nums[index] >= 0) include = next[t - nums[index]];

                //exclude
                boolean exclude = next[t];

                curr[t] = include || exclude;
            }

            System.arraycopy(curr,0,next,0,target+1);
        }

        return next[target];
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