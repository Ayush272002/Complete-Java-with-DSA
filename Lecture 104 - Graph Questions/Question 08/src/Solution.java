import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean dfs(int node, boolean[] vis, boolean[] pathVis, boolean[] safeNode, int[][] graph)
    {
        vis[node] = true;
        pathVis[node] = true;

        for(int nbr : graph[node])
        {
            if(pathVis[nbr]) return true;
            else if(!vis[nbr])
            {
                if(dfs(nbr,vis,pathVis,safeNode,graph))
                    return true;
            }
        }

        safeNode[node] = true;
        pathVis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] safeNodes = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i])
                dfs(i,visited,pathVis,safeNodes, graph);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < safeNodes.length; i++) {
            if(safeNodes[i]) ans.add(i);
        }

        return ans;
    }
}