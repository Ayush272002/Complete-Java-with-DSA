class SolutionUsingRecursion {
    private int solve(int n)
    {
        if(n <= 3) return n;

        int sq = 1;
        while((sq*sq)<=n) sq++;

        sq--; // to get back to the true condition in the loop

        int min = Integer.MAX_VALUE;
        for(int i = sq; i>=1; i--)
        {
            int count = 1 + solve(n- (i*i));
            min = Math.min(min,count);
        }
        return min;
    }
    public int numSquares(int n)
    {
        int ans = solve(n);
        return ans;
    }
}