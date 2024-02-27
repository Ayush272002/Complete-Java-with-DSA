import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution
{
    private List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int V)
    {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for(int nbr : adj.get(i))
                indegree[nbr]++;
        }

        //push all the 0 indegree vertices in the queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty())
        {
            //ans store
            int front = q.poll();

            ans.add(front);

            for(int nbr : adj.get(front))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }

        return ans;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here

        //adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        //graph construction
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(),s2.length());

            for (int j = 0; j < len; j++)
            {
                if(s1.charAt(j) != s2.charAt(j))
                {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }

            }
        }

        //topo-sort of the graph
        List<Integer> topo = topoSort(adj, K);
        StringBuilder ans = new StringBuilder();

        for(int n : topo)
        {
            ans.append((char) (n + 'a'));
        }

        return ans.toString();
    }
}