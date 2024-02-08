import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Write your code here.

        //create adjacency
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int i = 0; i < g.size(); i++) {
            int u = g.get(i).get(0);
            int v= g.get(i).get(1);
            int w = g.get(i).get(2);

            adj.computeIfAbsent(u,key->new ArrayList<>()).add(new Pair(v,w));
            adj.computeIfAbsent(v,key->new ArrayList<>()).add(new Pair(u,w));
        }

        ArrayList<Integer> key = new ArrayList<>(n+1);
        ArrayList<Boolean> mst = new ArrayList<>(n+1);
        ArrayList<Integer> parent = new ArrayList<>(n+1);

        for (int i = 0; i <= n; i++) {
            key.add(Integer.MAX_VALUE);
            parent.add(-1);
            mst.add(Boolean.FALSE);
        }

        //lets start the algorithm
        key.set(1,0); //the graphs source node is 1, setting it to 0
        parent.set(1,-1); //1 is the starting node and has no parent

        for (int i = 0; i < n; i++) {
            int mini = Integer.MAX_VALUE;
            int u = -1;

            //find the minimum node
            for (int v = 1; v <= n ; v++) {
                if(!mst.get(v) && key.get(v)<mini)
                {
                    u = v;
                    mini = key.get(v);
                }
            }

            //mark min node as true

            if(u != -1) mst.set(u,true);

            //check its adjacent nodes

            for(Pair it: adj.get(u))
            {
                int v = it.first;
                int w = it.second;

                if(!mst.get(v) && w < key.get(v))
                {
                    parent.set(v,u);
                    key.set(v,w);
                }
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 2 ; i <= n ; i++) //i != 0 cause no mapping of 0, i != 1 cause mapping of 1 is -1
        {
            result.add(new ArrayList<>());
            result.get(i-2).add(parent.get(i));
            result.get(i-2).add(i);
            result.get(i-2).add(key.get(i));
        }

        return result;
    }
}

//Time complexity - O(n^2)
