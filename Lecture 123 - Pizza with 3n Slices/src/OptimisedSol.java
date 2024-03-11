public class OptimisedSol
{
    private int solve(int[] slices)
    {
        int k = slices.length;
        int[] prev1 = new int[k+2]; //dp[index]
        int[] curr1 = new int[k+2]; //dp[index+1]
        int[] next1 = new int[k+2]; //dp[index+2]

        //case 1 : eat 1st slice
        for(int index = k-2; index >= 0; index--)
        {
            for(int n = 1; n <= k/3; n++)
            {
                //eat curr slice
                int take = slices[index] + next1[n-1];

                //not eat curr slice
                int notTake = curr1[n];

                prev1[n] = Math.max(take,notTake);
            }

            System.arraycopy(curr1,0,next1,0,k+2);
            System.arraycopy(prev1,0,curr1,0,k+2);
        }
        int case1 = curr1[k/3];

        //case 2: dont eat 1st slice
        prev1 = new int[k+2];
        curr1 = new int[k+2];
        next1 = new int[k+2];
        for(int index = k-1; index >= 1; index--)
        {
            for(int n = 1; n <= k/3; n++)
            {
                //eat curr slice
                int take = slices[index] + next1[n-1];

                //not eat curr slice
                int notTake = curr1[n];

                prev1[n] = Math.max(take,notTake);
            }
            System.arraycopy(curr1,0,next1,0,k+2);
            System.arraycopy(prev1,0,curr1,0,k+2);
        }
        int case2 = curr1[k/3];

        return Math.max(case1,case2);

    }
    public int maxSizeSlices(int[] slices)
    {
        return solve(slices);
    }
}
