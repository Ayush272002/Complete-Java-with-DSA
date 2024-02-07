import java.util.*;

public class Graph
{
    private Map<Integer, List<Pair>> adj;

    Graph()
    {
        adj = new HashMap<>();
    }

    void addEdge(int u, int v, int weight)
    {
        Pair temp = new Pair(v, weight);

        //create an edge if absent
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(temp);

        // Ensure that both u and v have an entry in the adjacency list
        adj.computeIfAbsent(v, k -> new ArrayList<>());

    }

    void printAdjList()
    {
        for(Map.Entry<Integer, List<Pair>> entry : adj.entrySet())
        {
            System.out.print(entry.getKey()+"->");

            for(Pair temp : entry.getValue())
            {
                System.out.print("("+temp.first+","+temp.second+")  ");
            }
            System.out.println();
        }
    }

    void dfs(int node, HashMap<Integer,Boolean> visited, Stack<Integer> topo)
    {
        visited.put(node,true);

        List<Pair> neighbours = adj.get(node);

        for (int i = 0; i < neighbours.size(); i++) {
            Pair neighbour = neighbours.get(i);

            if(!visited.getOrDefault(neighbour.first,false))
                dfs(neighbour.first, visited, topo);
        }

        topo.push(node);
    }

    void getShortestPath(int src, ArrayList<Integer> distance,  Stack<Integer> topo)
    {
        distance.set(src,0);

        while(!topo.isEmpty())
        {
            int top = topo.pop();

            if(distance.get(top) != Integer.MAX_VALUE)
            {
                for(Pair i : adj.get(top))
                {
                    if(distance.get(top) + i.second < distance.get(i.first))
                        distance.set(i.first, distance.get(top) + i.second);
                }
            }
        }
    }
}
