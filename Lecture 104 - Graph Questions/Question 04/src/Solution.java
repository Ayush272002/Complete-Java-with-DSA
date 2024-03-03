import java.util.*;
//kahans algorithm
class Solution {
    public int longestCycle(int[] edges)
    {
        int V = edges.length;

        HashMap<Integer,Boolean> visited = new HashMap<>();
        ArrayList<Integer> inDegree = new ArrayList<>(Collections.nCopies(V,0));


        for (int i = 0; i < edges.length; i++) {
            int nbr = edges[i];
            if (nbr != -1) {
                inDegree.set(nbr, inDegree.get(nbr) + 1);
            }
        }

        //push all the 0 inDegree Vertices in a queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if(inDegree.get(i)==0) q.add(i);
        }

        //do bfs
        while(!q.isEmpty())
        {
            int front = q.poll();
            visited.put(front,true);
            int nbr = edges[front];

            if (nbr != -1) {
                inDegree.set(nbr, inDegree.get(nbr) - 1);
                if (inDegree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < V; i++) {
            if(!visited.getOrDefault(i,false))
            {
                int nbr = edges[i];
                int cnt = 1;
                visited.put(i,true);

                while(nbr != i)
                {
                    visited.put(nbr,true);
                    cnt++;
                    nbr = edges[nbr];
                }
                ans = Math.max(cnt,ans);
            }
        }
        return ans;
    }
}