import java.util.HashMap;
import java.util.LinkedList;

public class Graph
{
    private int vertex;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked") Graph(int v)
    {
        this.vertex = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void add(int v, int w)
    {
        adj[v].add(w);
    }

    private void DFSHelper(int v, HashMap<Integer, Boolean> visited)
    {
        visited.put(v,true);

        System.out.print(v + " ");

        LinkedList<Integer> neighbour = adj[v];

        for (int i = 0; i < neighbour.size(); i++) {
            int temp = neighbour.get(i);
            if(!visited.getOrDefault(temp, false)) DFSHelper(temp,visited);
        }
    }

    public void DFS(int v)
    {
        HashMap<Integer, Boolean> visited = new HashMap<>();

        DFSHelper(v,visited);
    }
}
