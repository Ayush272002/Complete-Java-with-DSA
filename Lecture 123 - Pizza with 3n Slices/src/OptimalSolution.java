public class OptimalSolution
{
    private int loop(int[] slices, int k, int[] prev1, int[] curr1, int[] next1, int i, int i2) {
        int casE; //cant write case
        for(int index = k- i; index >= i2; index--)
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
        casE = curr1[k/3];
        return casE;
    }

    private int solve(int[] slices)
    {
        int k = slices.length;
        int[] prev1 = new int[k+2]; //dp[index]
        int[] curr1 = new int[k+2]; //dp[index+1]
        int[] next1 = new int[k+2]; //dp[index+2]

        //case 1 : eat 1st slice
        int case1 = loop(slices, k, prev1, curr1, next1, 2, 0);

        //case 2: dont eat 1st slice
        prev1 = new int[k+2];
        curr1 = new int[k+2];
        next1 = new int[k+2];
        int case2 = loop(slices, k, prev1, curr1, next1, 1, 1);

        return Math.max(case1,case2);

    }


    public int maxSizeSlices(int[] slices)
    {
        return solve(slices);
    }
}
