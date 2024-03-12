class BottomUpApproach
{
    private int solve(int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        int[][] dp = new int[n+1][2];

        for(int index = n-1; index >= 1; index--)
        {
            for(int swapped = 1; swapped >= 0; swapped--)
            {
                int ans = Integer.MAX_VALUE;
                int prev1 = nums1[index-1];
                int prev2 = nums2[index-1];

                //swap
                if(swapped == 1)
                {
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }

                //no swap
                if(nums1[index] > prev1 && nums2[index] > prev2)
                    ans = dp[index+1][0];


                //swap
                if(nums1[index] > prev2 && nums2[index] > prev1)
                    ans = Math.min(ans,1 + dp[index+1][1]);


                dp[index][swapped] = ans;

            }
        }
        return dp[1][0];
    }
    public int minSwap(int[] nums1, int[] nums2)
    {
        int[] n1 = new int[nums1.length+1];
        n1[0] = -1;
        System.arraycopy(nums1, 0, n1, 1, n1.length - 1);

        int[] n2 = new int[nums2.length+1];
        n2[0] = -1;
        System.arraycopy(nums2, 0, n2, 1, n2.length - 1);


        return solve(n1,n2);
    }
}