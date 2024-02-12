import java.util.*;

public class Solution {
    private static void dfs(int node,Map<Integer,Boolean> visited, Stack<Integer> stack, Map<Integer, List<Integer>> adj)
    {
        visited.put(node,true);

        for(Integer neighbour : adj.get(node))
        {
            if(!visited.getOrDefault(neighbour,false))
            {
                dfs(neighbour,visited,stack,adj);
            }
        }

        //topo sort
        stack.push(node);
    }

    private static void revDfs(int node, Map<Integer,Boolean> visited, Map<Integer,List<Integer>> transpose)
    {
        visited.put(node,true);

        for(Integer neighbour : transpose.get(node))
        {
            if(!visited.getOrDefault(neighbour,false))
            {
                revDfs(neighbour,visited,transpose);
            }
        }
    }

    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges)
    {
        // Write your code here.

        //adj list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < v; i++) {
            adj.put(i,new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            int u1 = edges.get(i).get(0);
            int v1 = edges.get(i).get(1);

            adj.get(u1).add(v1);
        }

        //topo sort

        Stack<Integer> stack = new Stack<>();
        Map<Integer,Boolean> visited = new HashMap<>();

        for (int i = 0; i < v; i++) {
            if(!visited.getOrDefault(i,false))
            {
                dfs(i,visited,stack,adj);
            }
        }

        //create a transpose graph
        Map<Integer,List<Integer>> transpose = new HashMap<>();

        for (int i = 0; i < v; i++) {
            transpose.put(i,new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            visited.put(i,false);
            for(Integer neighbour : adj.get(i))
            {
                transpose.get(neighbour).add(i);
            }
        }

        //dfs call using above ordering
        int count = 0;
        while(!stack.isEmpty())
        {
            int top = stack.pop();
            if(!visited.get(top))
            {
                count++;
                revDfs(top,visited,transpose);
            }
        }

        return count;
    }
}