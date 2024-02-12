import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static void dfs(int node, int parent, int timer, List<Integer> disc, List<Integer> low, List<List<Integer>> result, Map<Integer, List<Integer>> adj, Map<Integer, Boolean> visited)
    {
        visited.put(node,true);
        disc.set(node,timer);
        low.set(node,timer);
        timer++;

        for(Integer neighbour : adj.get(node))
        {
            if(neighbour == parent)
            {
                continue;
            }

            if(!visited.getOrDefault(neighbour,false)) {
                dfs(neighbour, node, timer, disc, low, result, adj, visited);
                low.set(node, Math.min(low.get(node), low.get(neighbour)));

                //check edge is bridge

                if (low.get(neighbour) > disc.get(node)) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(node);
                    ans.add(neighbour);

                    result.add(new ArrayList<>(ans));
                }
            }
            else
            {
                //back edge
                low.set(node, Math.min(low.get(node),disc.get(neighbour)));
            }
        }
    }
    public static List<List<Integer>> findBridges(int[][] edges, int v, int e)
    {
        // Write your code here!

        //adj list
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < v; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u1 = edges[i][0];
            int v1 = edges[i][1];

            adj.get(u1).add(v1);
            adj.get(v1).add(u1);
        }

        int timer = 0;
        List<Integer> disc = new ArrayList<>(v); //discovery time
        List<Integer> low = new ArrayList<>(v);//low time
        int parent = -1;

        Map<Integer, Boolean> visited = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            disc.add(-1);
            low.add(-1);
        }

        //dfs

        for (int i = 0; i < v; i++) {
            if(!visited.getOrDefault(i,false))
            {
                dfs(i,parent,timer,disc, low, result, adj, visited);
            }
        }

        return result;
    }
}