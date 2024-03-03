import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private void dfs(int[][] grid, boolean[][] visited,int r, int c, int[][] dir,ArrayList<Pair> coOrdinates, int baseX, int baseY)
    {
        visited[r][c] = true;
        coOrdinates.add(new Pair(r-baseX, c-baseY));

        for(int[] d : dir)
        {
            int x = r+d[0];
            int y = c+d[1];

            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visited[x][y])
                dfs(grid,visited,x,y,dir,coOrdinates, baseX, baseY);
        }

    }

    int countDistinctIslands(int[][] grid)
    {
        // Your Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<ArrayList<Pair>> set = new HashSet<>();
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1)
                {
                    ArrayList<Pair> coOrdinates = new ArrayList<>();
                    dfs(grid,visited,i,j,dir,coOrdinates, i ,j);
                    set.add(coOrdinates);
                }
            }
        }

        return set.size();
    }
}
