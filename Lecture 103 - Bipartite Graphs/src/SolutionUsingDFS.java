class SolutionUsingDFS {
    private boolean dfs(int node, boolean[] visited, int[] color, int[][] graph)
    {
        visited[node] = true;

        for(int nbr : graph[node])
        {
            if(!visited[nbr])
            {
                if(color[node] == 0) color[nbr] = 1;
                else color[nbr] = 0;
                if(!dfs(nbr,visited,color,graph)) return false;
            }
            else if(visited[nbr] && color[node] == color[nbr]) return false;
        }

        return true;
    }
    public boolean isBipartite(int[][] graph)
    {
        boolean[] visited = new boolean[graph.length];
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++)
        {
            if(!visited[i])
            {
                color[i] = 0;
                if(!dfs(i,visited,color,graph)) return false;
            }
        }
        return true;
    }
}