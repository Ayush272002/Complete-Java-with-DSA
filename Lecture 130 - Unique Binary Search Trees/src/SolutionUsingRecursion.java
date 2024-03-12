class SolutionUsingRecursion
{
    private int solve(int n)
    {
        if(n <= 1) return 1;

        int ans = 0;//think i as root nodes
        for (int i = 1; i <= n; i++) {
            ans += solve(i-1) * solve(n-i);
        }

        return ans;
    }
    public int numTrees(int n)
    {
        return solve(n);
    }
}