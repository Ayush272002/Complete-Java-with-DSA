import java.util.*;

class Solution {
    private boolean topo(int node, Map<Integer, List<Integer>> adj, Stack<Integer> st, HashMap<Integer,Boolean> visited)
    {
        if(visited.containsKey(node))
        {
            if(visited.get(node)) return false;
            return true;
        }
        visited.put(node,true);
        for(Integer nbr : adj.get(node))
        {
            if(!topo(nbr,adj,st,visited)) return false;
        }

        visited.put(node,false);
        st.push(node);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        int[] ans = new int[numCourses];
        //adj list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i,new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
        }

        HashMap<Integer,Boolean> visited = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if(!visited.getOrDefault(i,false))
                if(!topo(i,adj,st,visited)) return new int[0];
        }


        int i=numCourses-1;
        while(!st.isEmpty())
        {
            ans[i] = st.pop();
            i--;
        }

        return ans;
    }
}