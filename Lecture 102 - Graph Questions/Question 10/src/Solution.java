import java.util.*;

class Solution {
    private void topo(int node, ArrayList<ArrayList<Pair>> adj, Map<Integer,Boolean> visited, Stack<Integer> st)
    {
        visited.put(node,true);

        for(Pair nbr : adj.get(node))
        {
            int v = nbr.first;
            if(!visited.getOrDefault(v,false))
                topo(v,adj,visited,st);

        }

        st.push(node);
    }

    public int[] shortestPath(int N,int M, int[][] edges) {
        //Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v,w));
        }

        Map<Integer,Boolean> visited = new HashMap<>();


        //topo sort
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(!visited.getOrDefault(i,false))
                topo(i,adj,visited,st);
        }

        //do the distance thing
        int[] distance = new int[N];
        Arrays.fill(distance, (int) (1e9));

        distance[0] = 0; // first 0 is the source node
        while(!st.isEmpty())
        {
            int node = st.pop();

            for(Pair nbr : adj.get(node))
            {
                int v = nbr.first;
                int w = nbr.second;

                if(distance[node] + w < distance[v])
                    distance[v] = distance[node] + w;
            }
        }

        for (int i = 0; i < N; i++) {
            if(distance[i] == 1e9) distance[i] = -1;
        }

        return distance;
    }
}