import java.util.Arrays;

public class BottomUpApproach
{
    int maxi;
    private void solve(char[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,0));


        for (int r = row-1; r >= 0 ; r--)
        {
            for (int c = col-1; c >= 0 ; c--)
            {
                int right = dp[r][c+1];
                int diagonal = dp[r+1][c+1];
                int down = dp[r+1][c];

                if(matrix[r][c]=='1')
                {
                    dp[r][c] = Math.min(right, Math.min(diagonal,down)) + 1;
                    maxi = Math.max(dp[r][c],maxi);
                }
                else
                {
                    dp[r][c] = 0;
                }
            }  
        }
    }
    public int maximalSquare(char[][] matrix)
    {
        maxi = 0;
        solve(matrix);
        return maxi * maxi;
    }
}