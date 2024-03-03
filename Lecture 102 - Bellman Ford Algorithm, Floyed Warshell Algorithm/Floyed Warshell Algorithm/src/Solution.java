class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == -1) matrix[i][j] = (int)1e9;
                if(i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);

                }
            }
        }

        //negative cycle check
        for (int i = 0; i < n; i++) {
            if(matrix[i][i] < 0) System.out.println("Negative cycle");
        }

        //convert the 1e9 to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == (int)1e9) matrix[i][j] = -1;
            }
        }
    }
}