import java.util.Arrays;

class TopDownApproach
{
    private int solve(int index, int endIndex, int[] slices, int n, int[][] dp)
    {
        //base case
        if(n == 0 || index > endIndex) return 0;
        if(dp[index][n] != -1) return dp[index][n];

        //eat curr slice
        int take = slices[index] + solve(index+2,endIndex, slices,n-1, dp);

        //not eat curr slice
        int notTake = solve(index+1,endIndex, slices,n, dp);

        dp[index][n] = Math.max(take,notTake);

        return dp[index][n];
    }
    public int maxSizeSlices(int[] slices)
    {
        int k = slices.length;
        int[][] dp = new int[k][k/3 + 1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));

        //case 1 : eat 1st slice
        int case1 = solve(0,k-2,slices,k/3, dp);

        //case 2: dont eat 1st slice
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        int case2 = solve(1,k-1,slices,k/3, dp);

        return Math.max(case1,case2);
    }
}