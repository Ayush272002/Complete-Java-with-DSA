import java.util.ArrayList;
import java.util.HashMap;

public class SolutionUsingDFS
{
    boolean isCyclicDFS(int srcNode, int parent, HashMap<Integer, Boolean> visited, ArrayList<ArrayList<Integer>> adj)
    {
        visited.put(srcNode, true);

        ArrayList<Integer> adjOfFront = adj.get(srcNode);

        for (int i = 0; i < adjOfFront.size(); i++) {
            if(!visited.getOrDefault(adjOfFront.get(i), false))
            {
                boolean cycleDetected = isCyclicDFS(adjOfFront.get(i), srcNode, visited, adj);
                if(cycleDetected) return true;
            }
            else if(adjOfFront.get(i) != parent) return true;
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //to handel disconnected component
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < V; i++) {
            //checking if the neighbor is visited and also making sure
            // it's not the parent of the current node before deciding
            // to return true

            if (!visited.getOrDefault(i, false)) {
                boolean ans = isCyclicDFS(i,-1, visited, adj);
                if (ans) return true;
            }
        }

        return false;
    }
}
