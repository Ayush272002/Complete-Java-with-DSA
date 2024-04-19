public class UnionFind
{

    private int[] parents;
    private int[] rank;
    private int connections;
    private int[] edges;

    public UnionFind(int n)
    {
        parents = new int[n];
        rank = new int[n];
        edges = new int[n];
        connections = n;

        for (int i = 0; i < n; i++)
        {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int n1)
    {
        int res = n1;

        while (res != parents[res])
        {
            parents[res] = parents[parents[res]];
            res = parents[res];
        }

        return res;
    }

    public boolean union(int n1, int n2)
    {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2)
        {
            edges[p1]++;
            return false;
        }

        if (rank[p2] > rank[p1])
        {
            parents[p1] = p2;
            rank[p2] += rank[p1];
            edges[p2] += edges[p1] + 1;
        }
        else
        {
            parents[p2] = p1;
            rank[p1] += rank[p2];
            edges[p1] += edges[p2] + 1;
        }

        connections--;
        return true;
    }
}
