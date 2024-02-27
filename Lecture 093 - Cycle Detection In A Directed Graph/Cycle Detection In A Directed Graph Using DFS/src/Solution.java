import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis)
    {
        vis[node] = true;
        pathVis[node] = true;

        for(int nbr : adj.get(node))
        {
            if(pathVis[nbr]) return true;
            else if(!vis[nbr])
            {
                if(dfs(nbr,adj,vis,pathVis)) return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        boolean[] pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i])
            {
                if(dfs(i,adj,visited,pathVis)) return true;
            }
        }

        return false;
    }
}