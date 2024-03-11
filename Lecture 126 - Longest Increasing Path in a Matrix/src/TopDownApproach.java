import java.util.Arrays;

class TopDownApproach
{
    private int dfs(int[][] matrix, boolean[][] visited, int r, int c, int[][] dir, int[][] dp)
    {
        if(dp[r][c] != -1) return dp[r][c];
        visited[r][c] = true;
        int maxLen = 1;

        for(int[] d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];
            if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y] && matrix[x][y] > matrix[r][c])
            {
                maxLen = Math.max(maxLen, 1 + dfs(matrix,visited,x,y,dir, dp));
            }
        }


        visited[r][c] = false;
        dp[r][c] = maxLen;
        return dp[r][c];
    }
    public int longestIncreasingPath(int[][] matrix)
    {
        int max = Integer.MIN_VALUE;

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] visited = new boolean[row][col];
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] dp = new int[row][col];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max,dfs(matrix,visited,i,j,dir, dp));
            }
        }

        return max;
    }
}