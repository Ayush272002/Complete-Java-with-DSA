import java.util.Arrays;

class BottomUpApproach
{
    private int solve(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;

        if (row == 1 && col == 1) // Handle the case when the matrix has only one element
            return 1;

        int[][] dp = new int[row][col];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = Integer.MIN_VALUE;

        // Base case
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, 1));

        boolean madeProgress;
        do
        {
            madeProgress = false;

            for (int i = row - 1; i >= 0; i--)
            {
                for (int j = col - 1; j >= 0; j--)
                {
                    int maxLen = dp[i][j];

                    for (int[] d : dir)
                    {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] < matrix[i][j])
                        {
                            maxLen = Math.max(maxLen, 1 + dp[x][y]);
                        }

                    }
                    if (maxLen > dp[i][j])
                    {
                        dp[i][j] = maxLen;
                        ans = Math.max(ans, maxLen); // Update the maximum length based on maxLen
                        madeProgress = true;
                    }
                }
            }
        }
        while (madeProgress);

        return ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        return solve(matrix);
    }
}
