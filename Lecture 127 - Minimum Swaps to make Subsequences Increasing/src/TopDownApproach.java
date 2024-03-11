import java.util.Arrays;

class TopDownApproach
{
    private int solve(int[] nums1, int[] nums2, int index, boolean swapped, int[][] dp)
    {
        //base case
        if(index == nums1.length) return 0;
        int col = swapped ? 1 : 0;
        if(dp[index][col] != -1) return dp[index][col];

        int ans = Integer.MAX_VALUE;
        int prev1 = nums1[index-1];
        int prev2 = nums2[index-1];

        //swap
        if(swapped)
        {
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }

        //no swap
        if(nums1[index] > prev1 && nums2[index] > prev2)
            ans = solve(nums1,nums2,index+1,false, dp);


        //swap
        if(nums1[index] > prev2 && nums2[index] > prev1)
            ans = Math.min(ans,1 + solve(nums1, nums2, index+1, true, dp));


        dp[index][col] = ans;
        return dp[index][col];
    }
    public int minSwap(int[] nums1, int[] nums2)
    {
        int[] n1 = new int[nums1.length+1];
        n1[0] = -1;
        System.arraycopy(nums1, 0, n1, 1, n1.length - 1);

        int[] n2 = new int[nums2.length+1];
        n2[0] = -1;
        System.arraycopy(nums2, 0, n2, 1, n2.length - 1);

        boolean swapped = false; // it means that the prev indexes were swapped ot not

        int[][] dp = new int[n1.length][2];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(n1,n2,1,swapped, dp);
    }
}