import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private void dfs(int node, HashMap<Integer,Boolean> visited, Map<Integer, List<Integer>> adj)
    {
        visited.put(node,true);

        for(Integer nbr : adj.get(node))
        {
            if(!visited.getOrDefault(nbr,false))
                dfs(nbr,visited,adj);
        }
    }
    public int findCircleNum(int[][] isConnected)
    {
        //Adj list
        int vertices = isConnected.length;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adj.put(i,new ArrayList<>());
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if(isConnected[i][j] == 1)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        HashMap<Integer,Boolean> visited = new HashMap<>();
        int count = 0;

        for (int i = 0; i < vertices; i++) {
            if(!visited.getOrDefault(i,false))
            {
                count++;
                dfs(i,visited,adj);
            }
        }

        return count;
    }
}