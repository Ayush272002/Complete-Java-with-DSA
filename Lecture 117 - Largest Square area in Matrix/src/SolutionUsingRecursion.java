class SolutionUsingRecursion
{
    int maxi;
    private int solve(char[][] matrix, int r, int c)
    {
        if(r >= matrix.length || c >= matrix[0].length) return 0;

        int right = solve(matrix, r, c+1);
        int diagonal = solve(matrix, r+1, c+1);
        int down = solve(matrix, r+1, c);

        if(matrix[r][c]=='1')
        {
            int ans = Math.min(right, Math.min(diagonal,down)) + 1;
            maxi = Math.max(ans,maxi);
            return ans;
        }
        else return 0;
    }
    public int maximalSquare(char[][] matrix)
    {
        maxi = 0;
        solve(matrix,0,0);
        return maxi * maxi;
    }
}