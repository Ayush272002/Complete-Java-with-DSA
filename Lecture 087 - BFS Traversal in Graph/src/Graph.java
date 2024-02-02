import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph
{
    private final int numVertex; //number of vertices

    private final LinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked") Graph(int numVertex)
    {
        this.numVertex = numVertex;

        adjacencyList = new LinkedList[numVertex];
        for (int i = 0; i < numVertex; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void add(int v, int w)
    {
        adjacencyList[v].add(w);
    }

    public void BFS(int s) //s is the source vertex from where BFS needs to be performed
    {
        HashMap<Integer, Boolean> visited = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();

        visited.put(s,true); //mark the current as visited

        q.add(s);

        while(!q.isEmpty())
        {
            int temp = q.poll();
            System.out.print(temp + " ");

            //get all the adjacent vertices of temp

            LinkedList<Integer> adj = adjacencyList[temp];

            for (int i = 0; i < adj.size(); i++) {
                if(!visited.getOrDefault(adj.get(i), false))
                {
                    q.add(adj.get(i));
                    visited.put(adj.get(i), true);
                }
            }
        }
    }
}