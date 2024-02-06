import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here

        //find all inDegrees - no. of incoming edges
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
        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            //ans store
            int front = q.poll();

            ans.add(front);

            ArrayList<Integer> neighbours = adj.get(front);

            for (int j = 0; j < neighbours.size(); j++) {

                int neighbour = neighbours.get(j);
                inDegree.set(neighbour, inDegree.get(neighbour) - 1);

                if(inDegree.get(neighbour)==0) q.add(neighbour);
            }

        }

        // Convert ArrayList to array
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
