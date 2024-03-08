import java.util.Arrays;

class TopDownApproach
{
    private int maxi;
    private int solve(char[][] matrix, int r, int c, int[][] dp)
    {
        if(r >= matrix.length || c >= matrix[0].length) return 0;
        if(dp[r][c] != -1) return dp[r][c];

        int right = solve(matrix, r, c+1, dp);
        int diagonal = solve(matrix, r+1, c+1, dp);
        int down = solve(matrix, r+1, c, dp);

        if(matrix[r][c]=='1')
        {
            dp[r][c] = Math.min(right, Math.min(diagonal,down)) + 1;
            maxi = Math.max(dp[r][c],maxi);
        }
        else
        {
            dp[r][c] = 0;
        }
        return dp[r][c];
    }
    public int maximalSquare(char[][] matrix)
    {
        maxi = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        Arrays.stream(dp).forEach(row->Arrays.fill(row,-1));

        solve(matrix,0,0,dp);
        return maxi*maxi;
    }
}