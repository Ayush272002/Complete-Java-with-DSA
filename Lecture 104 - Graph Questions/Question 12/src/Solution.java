import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minimumEffortPath(int[][] heights)
    {
        PriorityQueue<Node> q = new PriorityQueue<>((x,y)->x.distance-y.distance);

        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];

        Arrays.stream(dist).forEach(r->Arrays.fill(r,Integer.MAX_VALUE));

        q.add(new Node(0,0,0));
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty())
        {
            Node temp = q.poll();

            int diff = temp.distance;
            int row = temp.x;
            int col = temp.y;

            if(row == n-1 && col == m-1) return diff;

            for(int[] d : dir)
            {
                int newX = row + d[0];
                int newY = col + d[1];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m)
                {
                    int newDiff = Math.max(Math.abs(heights[row][col] - heights[newX][newY]), diff);

                    if(newDiff < dist[newX][newY])
                    {
                        dist[newX][newY] = newDiff;
                        q.add(new Node(newDiff, newX, newY));
                    }
                }
            }
        }

        return 0;
    }
}