import java.util.*;

class Solution {
    private void dfs(int node, int parent, List<Integer> dis, List<Integer> low, Map<Integer,Boolean> visited, HashMap<Integer,List<Integer>> adj, List<List<Integer>> articulationPoints, int timer)
    {
        visited.put(node,true);
        dis.set(node,timer);
        low.set(node,timer);
        timer++;
        int child = 0;

        for(Integer nbr : adj.get(node))
        {
            if(nbr==parent) continue;

            if(!visited.getOrDefault(nbr,false))
            {
                dfs(nbr,node,dis,low,visited,adj,articulationPoints,timer);
                low.set(node,Math.min(low.get(node),low.get(nbr)));

                //check for articulation points
                if(low.get(nbr) > dis.get(node))
                {
                    articulationPoints.add(Arrays.asList(node,nbr));
                }
                child++;
            }
            else
            {
                //back edge case
                low.set(node,Math.min(low.get(node),dis.get(nbr)));
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
    {
        //adj list
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i,new ArrayList<>());
        }

        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int timer = 0;
        List<Integer> disc = new ArrayList<>(Collections.nCopies(n,-1));  //discovery time
        List<Integer> low = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));


        Map<Integer,Boolean> visited = new HashMap<>();
        List<List<Integer>> articulationPoints = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(!visited.getOrDefault(i,false))
                dfs(i,-1,disc,low,visited,adj,articulationPoints, timer);
        }
        return articulationPoints;
    }
}