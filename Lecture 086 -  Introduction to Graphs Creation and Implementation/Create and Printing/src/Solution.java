import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges)
    {
        // Write your code here.
        // Initialize the adjacency list
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();


        for (int i = 0; i < m; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // Convert the adjacency list to int[][]
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            int graphSize = graph[i].size();
            int[] temp = new int[graphSize+1];
            temp[0] = i;

            for (int j = 0; j < graph[i].size(); j++) {
                temp[j+1] = graph[i].get(j);
            }

            result[i] = temp;
        }

        return result;
    }
}