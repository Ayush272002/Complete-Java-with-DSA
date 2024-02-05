import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetectCycleUsingDFS {

    private boolean checkCycleDFS(int node,  Map<Integer, Boolean> visited, Map<Integer, Boolean> dfsVisited, ArrayList<ArrayList<Integer>> adj)
    {
        visited.put(node,true);
        dfsVisited.put(node,true);

        ArrayList<Integer> neighbours = adj.get(node);

        for (int i = 0; i < neighbours.size(); i++)
        {
            int neighbour = neighbours.get(i);
            if(!visited.getOrDefault(neighbour,false))
            {
                boolean cycleDetected = checkCycleDFS(neighbour, visited, dfsVisited, adj);
                if(cycleDetected) return true;
            }
            else if(dfsVisited.get(neighbour))
            {
                //visited
                return true;
            }
        }

        dfsVisited.put(node,false);
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here

        //call dfs for all components
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Boolean> dfsVisited = new HashMap<>();

        for (int i = 0; i < V; i++) {
            if(!visited.getOrDefault(i,false))
            {
                boolean cycleFound = checkCycleDFS(i, visited, dfsVisited, adj);
                if(cycleFound) return true;
            }
        }
        return false;
    }
}
