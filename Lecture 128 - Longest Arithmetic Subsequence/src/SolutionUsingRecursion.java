class SolutionUsingRecursion
{
    private int solve(int index, int diff, int[] nums)
    {
        //backward check

        if(index < 0) return 0;

        int ans = 0;
        for(int j = index-1; j >= 0; j--)
        {
            if(nums[index]- nums[j] == diff)
            {
                ans = Math.max(ans,1 + solve(j,diff,nums));
            }
        }

        return ans;
    }
    public int longestArithSeqLength(int[] nums)
    {
        int n = nums.length;
        if(n <= 2) return n;


        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                ans = Math.max(ans,2 + solve(i,nums[j]-nums[i], nums));
            }
        }

        return ans;
    }
}