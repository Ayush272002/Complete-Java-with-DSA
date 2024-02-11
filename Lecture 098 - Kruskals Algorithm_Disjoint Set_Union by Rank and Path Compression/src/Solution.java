import java.util.*;

public class Solution {

    private static void makeSet(ArrayList<Integer> parent, ArrayList<Integer> rank, int n)
    {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    private static int findParent(ArrayList<Integer> parent, int node)
    {
        if(parent.get(node) == node)
        {
            return node;
        }
        //path compression
        parent.set(node,findParent(parent,parent.get(node)));

        return parent.get(node);
    }

    private static void unionSet(int u, int v, ArrayList<Integer> parent, ArrayList<Integer> rank)
    {
        u = findParent(parent, u);
        v = findParent(parent, v);

        if(rank.get(u) < rank.get(v))
        {
            parent.set(u,v);
        }
        else if(rank.get(u) > rank.get(v))
        {
            parent.set(v,u);
        }
        else
        {
            parent.set(v,u);
            rank.set(u, rank.get(u)+1);
        }
    }
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n)
    {
        //Your code goes here
        //sorting on basis of weight
        edges.sort(Comparator.comparingInt(a -> a.get(2)));

        ArrayList<Integer> parent = new ArrayList<>(n);
        ArrayList<Integer> rank = new ArrayList<>(n);
        makeSet(parent,rank, n);

        int minWeight = 0;

        for (int i = 0; i < edges.size(); i++) {
            int u = findParent(parent,edges.get(i).get(0));
            int v = findParent(parent, edges.get(i).get(1));
            int w = edges.get(i).get(2);

            if(u != v)
            {
                unionSet(u,v,parent, rank);
                minWeight += w;
            }

        }

        return minWeight;
    }
}