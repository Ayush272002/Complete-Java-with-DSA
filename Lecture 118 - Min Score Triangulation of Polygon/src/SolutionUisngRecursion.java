class SolutionUisngRecursion
{
    private int solve(int[] values, int i, int j)
    {
        if(i + 1 == j) return 0;

        int ans = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            ans = Math.min(ans, values[i]*values[j]*values[k] + solve(values, i,k) + solve(values, k,j));
        }

        return ans;
    }
    public int minScoreTriangulation(int[] values)
    {
        return solve(values,0,values.length-1);
    }
}