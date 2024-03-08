class OptimalSol
{
    private int solve(char[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;

        int maxi = 0;

        for (int r = row-1; r >= 0 ; r--)
        {
            for (int c = col-1; c >= 0 ; c--)
            {
                if(matrix[r][c] == '1')
                {
                    if(r == row-1 || c == col-1) matrix[r][c] = '1';
                    else
                    {
                        int right = matrix[r][c+1]- '0';
                        int diagonal = matrix[r+1][c+1] - '0';
                        int down = matrix[r+1][c] - '0';

                        int temp = 1 + Math.min(right, Math.min(diagonal,down));
                        matrix[r][c] = (char)('0' + temp);
                    }

                    maxi = Math.max(maxi, matrix[r][c]-'0');
                }
            }
        }

        return maxi * maxi;
    }
    public int maximalSquare(char[][] matrix)
    {
        return solve(matrix);
    }
}
