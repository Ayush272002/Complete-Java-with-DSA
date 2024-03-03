import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold)
    {
        int[][] matrix = new int[n][n];

        //fill the matrix with int max
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
            matrix[i][i] = 0; //distance from i node to itself is 0
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            matrix[u][v] = w;
            matrix[v][u] = w; //back connection
        }

        //floyed warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] <= distanceThreshold) count++;
            }

            if(count <= min)
            {
                min = count;
                city = i;
            }
        }

        return city;
    }
}