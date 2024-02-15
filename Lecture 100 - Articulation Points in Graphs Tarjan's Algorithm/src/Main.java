import java.util.*;

public class Main
{
    private static void dfs(int node, int parent, List<Integer> disc, List<Integer> low, Map<Integer, Boolean> visited, Map<Integer, List<Integer>> adj, List<Integer> ap, int timer)
    {
        visited.put(node,true);
        disc.set(node,timer);
        low.set(node,timer);
        timer++;
        //int child = 0;

        for(Integer neighbour : adj.get(node))
        {
            if(neighbour == parent) continue;

            if(!visited.getOrDefault(neighbour,false))
            {
                dfs(neighbour, node, disc, low, visited, adj, ap, timer);
                low.set(node, Math.min(low.get(node), low.get(neighbour)));

                //check articulation point
                if(low.get(neighbour) > disc.get(node))
                {
                    ap.set(node,1);
                }
                /*if(low.get(neighbour) >= disc.get(node) && parent != -1)
                {
                    ap.set(node,1);
                }*/
                //child++;
            }
            else
            {
                //back edge
                low.set(node, Math.min(low.get(node),disc.get(neighbour)));
            }
        }

        /*if(parent == -1 && child > 1)
        {
            ap.set(node,1);
        }*/

        //the commented condition is rarely used
    }
    public static void main(String[] args)
    {
        int n = 5; //no. of nodes
        int e = 5; // no. of edges

        //graph given in photo
        List<Pair> edges = new ArrayList<>();
        edges.add(new Pair(0,3));
        edges.add(new Pair(3,4));
        edges.add(new Pair(0,4));
        edges.add(new Pair(0,1));
        edges.add(new Pair(1,2));

        //adj list
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).first;
            int v = edges.get(i).second;

            adj.computeIfAbsent(u,key->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,key->new ArrayList<>()).add(u);
        }

        int timer = 0;
        List<Integer> disc = new ArrayList<>(Collections.nCopies(n, -1)); // discovery time
        List<Integer> low = new ArrayList<>(Collections.nCopies(n, -1)); //low time

        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> ap = new ArrayList<>(Collections.nCopies(n, 0));//articulation point


        //dfs
        for (int i = 0; i < n; i++) {
            if(!visited.getOrDefault(i,false))
                dfs(i,-1/*parent of current node is -1*/, disc, low, visited,adj, ap, timer);
        }

        //print articulation point
        System.out.println("Articulation points are as follows");

        for (int i = 0; i < n; i++) {
            if(ap.get(i) != 0) System.out.print(i+" ");
        }
    }
}

/*

Tarjan's Algorithm
Time complexity =  O(n+e)
Space complexity = O(n)

 */
