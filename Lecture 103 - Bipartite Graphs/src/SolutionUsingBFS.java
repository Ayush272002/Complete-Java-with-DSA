import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionUsingBFS {
    public boolean isBipartite(int[][] graph)
    {
        boolean[] visited = new boolean[graph.length];
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        Queue<Integer> q = new LinkedList<>();

        for (int start = 0; start < graph.length; start++)
        {
            if(!visited[start])
            {
                visited[start] = true;
                q.add(start);
                //0 and 1 will be the color
                color[start] = 0;
                while(!q.isEmpty())
                {
                    int node = q.poll();
                    int[] adj = graph[node];
                    for(int i : adj)
                    {
                        if(!visited[i])
                        {
                            if(color[node] == 0) color[i] = 1;
                            else color[i] = 0;
                            visited[i] = true;
                            q.add(i);
                        }
                        else if(visited[i] && color[node] == color[i])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}