class SolutionUsingRecursion
{
    private int solve(int start, int end)
    {
        //base case
        if(start >= end) return 0;

        int maxi = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            maxi = Math.min(maxi, i + Math.max(solve(start,i-1), solve(i+1,end)));
        }

        return maxi;
    }
    public int getMoneyAmount(int n)
    {
        return solve(1,n);
    }
}