import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class Solution
{
    static void topo(int node, HashMap<Integer, Boolean> visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj)
    {
        visited.put(node, true);

        ArrayList<Integer> neighbours = adj.get(node);

        for (int i = 0; i < neighbours.size(); i++)
        {
            int neighbour = neighbours.get(i);
            if(!visited.getOrDefault(neighbour,false))
            {
                topo(neighbour,visited,stack,adj);
            }
        }

        stack.push(node);
    }
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here

        //call dfs topological sort util function for all components


        HashMap<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if(!visited.getOrDefault(i,false))
                topo(i, visited, stack, adj);
        }

        int[] ans = new int[stack.size()];
        int i=0;

        while(!stack.isEmpty())
        {
            ans[i] = stack.pop();
            i++;
        }

        return ans;
    }
}
