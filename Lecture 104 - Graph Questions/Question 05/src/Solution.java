import java.util.*;

class Solution {
    private boolean dfs(int node, Map<Integer,Boolean> visited, Map<Integer, List<Integer>> adj)
    {
        if(visited.containsKey(node))
        {
            if(visited.get(node)) return false;
            return true; //not visited
        }


        visited.put(node,true);
        for(Integer nbr : adj.getOrDefault(node,new ArrayList<>()))
        {
            if(!dfs(nbr,visited,adj)) return false;
        }
        visited.put(node,false); //backtrack
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i,new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
        }
        Map<Integer,Boolean> visited = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if(!visited.getOrDefault(i,false))
                if(!dfs(i,visited,adj)) return false;
        }

        return true;
    }
}