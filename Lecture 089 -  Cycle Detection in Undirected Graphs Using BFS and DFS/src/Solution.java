import java.util.*;

class Solution {
    boolean isCyclicBFS(int srcNode, HashMap<Integer, Boolean> visited, ArrayList<ArrayList<Integer>> adj)
    {
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(srcNode, -1);
        visited.put(srcNode, true);

        Queue<Integer> q = new LinkedList<>();
        q.add(srcNode);

        while (!q.isEmpty())
        {
            int front = q.poll();

            ArrayList<Integer> adjOfFront = adj.get(front);

            for (int i = 0; i < adjOfFront.size(); i++) {
                if(visited.getOrDefault(adjOfFront.get(i), false) && !Objects.equals(adjOfFront.get(i), parentMap.get(front)))
                    return true;
                else if(!visited.getOrDefault(adjOfFront.get(i), false))
                {
                    q.add(adjOfFront.get(i));
                    visited.put(adjOfFront.get(i) , true);
                    parentMap.put(adjOfFront.get(i), front);
                }
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here

        //to handel disconnected component
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < V; i++) {
            //checking if the neighbor is visited and also making sure
            // it's not the parent of the current node before deciding
            // to return true

            if (!visited.getOrDefault(i, false)) {
                boolean ans = isCyclicBFS(i, visited, adj);
                if (ans) return true;
            }
        }

        return false;
    }
}