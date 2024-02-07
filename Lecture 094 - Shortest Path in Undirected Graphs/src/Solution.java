import java.util.*;

public class Solution {

    private static ArrayList<ArrayList<Integer>> createAdjacencyList(int n, int m, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    private static LinkedList<Integer> revList(LinkedList<Integer> ans)
    {
        LinkedList<Integer> rev = new LinkedList<>();
        for (int i = ans.size()-1; i >= 0 ; i--)
        {
            rev.add(ans.get(i));
        }
        return rev;
    }
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        // Write your code here.

        //create adj list
        ArrayList<ArrayList<Integer>> adj = createAdjacencyList(n, m, edges);

        //do bfs
        Map<Integer,Boolean> visited = new HashMap<>();
        Map<Integer,Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        parent.put(s,-1);

        while(!queue.isEmpty())
        {
            int front = queue.poll();

            ArrayList<Integer> neighbours = adj.get(front);

            for (int i = 0; i < neighbours.size(); i++)
            {
                int neighbour = neighbours.get(i);
                if(!visited.getOrDefault(neighbour,false))
                {
                    visited.put(neighbour,true);
                    parent.put(neighbour,front);
                    queue.add(neighbour);
                }
            }
        }

        //prepare the shortest path
        LinkedList<Integer> ans = new LinkedList<>();
        int currentNode = t;
        ans.add(t);

        while(currentNode != -1 && currentNode != s)
        {
            currentNode = parent.get(currentNode);
            if (currentNode != -1) {
                ans.add(currentNode);
            }
        }

        return revList(ans);
    }

}