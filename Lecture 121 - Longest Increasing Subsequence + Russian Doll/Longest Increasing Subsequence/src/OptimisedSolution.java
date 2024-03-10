public class OptimisedSolution
{
    private int solve(int[] nums)
    {
        int n = nums.length;
        int[] cur = new int[n+1];
        int[] next = new int[n+1];

        for (int curr = n-1; curr >= 0 ; curr--)
        {
            for (int prev = curr-1; prev >= -1; prev--)
            {
                //include
                int include = 0;
                if(prev == -1 || nums[curr] > nums[prev])
                {
                    include = 1 + next[curr+1];
                }

                //exclude
                int exclude = next[prev+1];

                cur[prev+1] = Math.max(include,exclude);
            }

            System.arraycopy(cur,0,next,0,n+1);
        }

        return next[0];
    }
    public int lengthOfLIS(int[] nums)
    {
        return solve(nums);
    }
}
