class SolutionUsingRecursion
{
    private int solve(int index, int endIndex, int[] slices, int n)
    {
        //base case
        if(n == 0 || index > endIndex) return 0;

        //eat curr slice
        int take = slices[index] + solve(index+2,endIndex, slices,n-1);

        //not eat curr slice
        int notTake = solve(index+1,endIndex, slices,n);

        return Math.max(take,notTake);
    }
    public int maxSizeSlices(int[] slices)
    {
        int k = slices.length;

        //case 1 : eat 1st slice
        int case1 = solve(0,k-2,slices,k/3);

        //case 2: dont eat 1st slice
        int case2 = solve(1,k-1,slices,k/3);

        return Math.max(case1,case2);
    }
}