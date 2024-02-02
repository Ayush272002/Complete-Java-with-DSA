import java.util.ArrayList;
import java.util.HashMap;

class Solution
{
    private void DFS(int V, ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ans, HashMap<Integer, Boolean> visited)
    {
        ans.add(V);
        visited.put(V,true);
        ArrayList<Integer> neighbours = adj.get(V);

        for (int i = 0; i < neighbours.size(); i++) {
            int temp = neighbours.get(i);
            if(!visited.getOrDefault(temp, false)) DFS(temp, adj,ans, visited);
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        DFS(0,adj, ans, visited);
        return ans;
    }
}