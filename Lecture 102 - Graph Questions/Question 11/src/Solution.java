import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int[] shortestPath(int[][] edges,int n,int m ,int src)
    {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);

        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty())
        {
            int node = q.poll();

            for(int nbr : adj.get(node))
            {
                if(dist[node] + 1 < dist[nbr])
                {
                    dist[nbr] = dist[node] + 1;
                    q.add(nbr);
                }
            }
        }

        Arrays.setAll(dist, i -> dist[i] == 1e9 ? -1 : dist[i]);

        return dist;
    }
}