import java.util.* ;
import java.io.*;
public class Solution {

    public static ArrayList <Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source)
    {
        // Write your code here.

        //create adjacency list
        Map<Integer, List<Pair>> adj = new HashMap<>();


        for (int i = 0; i < edges; i++) {
            int u = vec.get(i).get(0);
            int v = vec.get(i).get(1);
            int w = vec.get(i).get(2);

            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new Pair(v, w));
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(new Pair(u, w));
        }

        ArrayList<Integer> distance = new ArrayList<>(Collections.nCopies(vertices, Integer.MAX_VALUE));

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        distance.set(source,0);
        minHeap.add(new Pair(0,source));

        while(!minHeap.isEmpty())
        {
            Pair top = minHeap.poll();

            int nodeDistance = top.first;
            int topNode = top.second;

            //traverse on neighbours
            for(Pair neighbours : adj.getOrDefault(topNode,Collections.emptyList()))
            {
                if(nodeDistance + neighbours.second < distance.get(neighbours.first))
                {
                    // Update distance
                    distance.set(neighbours.first, nodeDistance + neighbours.second);

                    // Insert into the heap
                    minHeap.add(new Pair(distance.get(neighbours.first), neighbours.first));
                }

            }
        }
        return distance;
    }
}