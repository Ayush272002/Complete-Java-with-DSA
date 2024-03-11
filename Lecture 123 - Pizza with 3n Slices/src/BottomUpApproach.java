public class BottomUpApproach
{
    private int solve(int[] slices)
    {
        int k = slices.length;
        int[][] dp1 = new int[k+2][k/3 +1];
        int[][] dp2 = new int[k+2][k/3 +1];

        //case 1 : eat 1st slice
        for(int index = k-2; index >= 0; index--)
        {
            for(int n = 1; n <= k/3; n++)
            {
                //eat curr slice
                int take = slices[index] + dp1[index+2][n-1];

                //not eat curr slice
                int notTake = dp1[index+1][n];

                dp1[index][n] = Math.max(take,notTake);
            }
        }
        int case1 = dp1[0][k/3];

        //case 2: dont eat 1st slice
        for(int index = k-1; index >= 1; index--)
        {
            for(int n = 1; n <= k/3; n++)
            {
                //eat curr slice
                int take = slices[index] + dp2[index+2][n-1];

                //not eat curr slice
                int notTake = dp2[index+1][n];

                dp2[index][n] = Math.max(take,notTake);
            }
        }
        int case2 = dp2[1][k/3];

        return Math.max(case1,case2);

    }
    public int maxSizeSlices(int[] slices)
    {
        return solve(slices);
    }
}
