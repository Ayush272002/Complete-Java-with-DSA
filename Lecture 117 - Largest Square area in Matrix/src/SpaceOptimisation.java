import java.util.Arrays;

class SpaceOptimisation
{
    int maxi;
    private void solve(char[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] curr = new int[col+1];
        Arrays.fill(curr,0);

       int[] next = new int[col+1];
       Arrays.fill(next,0);


        for (int r = row-1; r >= 0 ; r--)
        {
            for (int c = col-1; c >= 0 ; c--)
            {
                int right = curr[c+1];
                int diagonal = next[c+1];
                int down = next[c];

                if(matrix[r][c]=='1')
                {
                    curr[c] = Math.min(right, Math.min(diagonal,down)) + 1;
                    maxi = Math.max(curr[c],maxi);
                }
                else
                {
                    curr[c] = 0;
                }
            }

            System.arraycopy(curr, 0, next, 0, col + 1);

        }
    }
    public int maximalSquare(char[][] matrix)
    {
        maxi = 0;
        solve(matrix);
        return maxi * maxi;
    }
}