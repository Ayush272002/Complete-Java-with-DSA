import java.util.*;

public class OptimisedSol {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        // Write your code here.

        //create adjacency
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int i = 0; i < g.size(); i++) {
            int u = g.get(i).get(0);
            int v = g.get(i).get(1);
            int w = g.get(i).get(2);

            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new Pair(v, w));
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(new Pair(u, w));
        }

        ArrayList<Integer> key = new ArrayList<>(n + 1);
        ArrayList<Boolean> mst = new ArrayList<>(n + 1);
        ArrayList<Integer> parent = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            key.add(Integer.MAX_VALUE);
            parent.add(-1);
            mst.add(Boolean.FALSE);
        }

        // Priority queue for maintaining vertices with minimum key
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));

        // Start from vertex 1
        key.set(1, 0);
        pq.offer(new Pair(1, 0));

        // Prim's algorithm
        while (!pq.isEmpty()) {
            int u = pq.poll().first;
            mst.set(u, true);

            // Traverse adjacent vertices of u
            for (Pair it : adj.getOrDefault(u, new ArrayList<>())) {
                int v = it.first;
                int w = it.second;

                if (!mst.get(v) && w < key.get(v)) {
                    parent.set(v, u);
                    key.set(v, w);
                    pq.offer(new Pair(v, w)); // Update priority queue
                }
            }
        }

        // Construct result
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            result.add(new ArrayList<>());
            result.get(i - 2).add(parent.get(i));
            result.get(i - 2).add(i);
            result.get(i - 2).add(key.get(i));
        }

        return result;
    }
}

//time complexity - O(n logn)