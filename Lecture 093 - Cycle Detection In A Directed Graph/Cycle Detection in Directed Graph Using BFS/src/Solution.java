import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        ArrayList<Integer> inDegree = new ArrayList<>(Collections.nCopies(V, 0));

        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> neighbours = adj.get(i);

            for (int j = 0; j < neighbours.size(); j++) {
                int neighbour = neighbours.get(j);
                inDegree.set(neighbour, inDegree.get(neighbour) + 1);
            }
        }

        //push all the 0 inDegree vertices in the queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if(inDegree.get(i) == 0) q.add(i);
        }

        //Do BFS
        int count = 0;

        while(!q.isEmpty())
        {
            //ans store
            int front = q.poll();

            //increment count
            count++;

            ArrayList<Integer> neighbours = adj.get(front);

            for (int j = 0; j < neighbours.size(); j++) {

                int neighbour = neighbours.get(j);
                inDegree.set(neighbour, inDegree.get(neighbour) - 1);

                if(inDegree.get(neighbour)==0) q.add(neighbour);
            }

        }
        return !(count==V);
    }
}