import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph
{
    private final Map<Integer, List<Integer>> adj;

    Graph()
    {
        adj = new HashMap<>();
    }

    void addEdge(int u, int v, boolean direction)
    {
        //u -> starting edge , v-> destination vertex
        //direction = false -> undirected
        //direction = true -> directed

        //create an edge from u to v
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);

        if (!direction)
        {
            // if undirected, also add an edge from v to u
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

    }

    void printAdjList() {
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet())
        {
            int key = entry.getKey();
            List<Integer> values = entry.getValue();

            System.out.print(key + "->");

            for (int i = 0; i < values.size(); i++)
            {
                System.out.print(values.get(i));
                if (i < values.size() - 1) System.out.print(",");
            }

            System.out.println();
        }
    }

}
