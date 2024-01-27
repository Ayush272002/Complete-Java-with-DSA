import java.util.ArrayList;

class Solution
{
    private static boolean isSafe(int newX, int newY, boolean[][] visited, int[][] arr, int n)
    {
        return (newX >= 0 && newX < n) && (newY >= 0 && newY < n) && !visited[newX][newY] && arr[newX][newY] == 1;
    }

    private static void solve(int x, int y, int[][] arr, int n, ArrayList<String> ans, boolean[][] visited, StringBuilder path)
    {
        if(x == n-1 && y == n-1)
        {
            ans.add(path.toString());
            return;
        }


        //4 movements
        //D , L , R , U

        visited[x][y] = true;
        //Down
        if(isSafe(x+1, y , visited, arr ,n))
        {
            solve(x+1,y, arr, n ,ans , visited, path.append('D'));
            path.deleteCharAt(path.length() - 1); // Backtrack
        }

        //Left
        if(isSafe(x, y-1 , visited, arr ,n))
        {
            solve(x,y-1, arr, n ,ans , visited, path.append('L'));
            path.deleteCharAt(path.length() - 1); // Backtrack
        }

        //Right
        if(isSafe(x, y+1 , visited, arr ,n))
        {
            solve(x,y+1, arr, n ,ans , visited, path.append('R'));
            path.deleteCharAt(path.length() - 1); // Backtrack
        }

        //UP
        if(isSafe(x-1, y , visited, arr ,n))
        {
            solve(x-1,y, arr, n ,ans , visited, path.append('U'));
            path.deleteCharAt(path.length() - 1); // Backtrack
        }

        visited[x][y] = false;
    }

    public static ArrayList<String> findPath(int[][] m, int n)
    {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[m.length][m[0].length];

        if(m[0][0] == 0) return ans;

        StringBuilder path = new StringBuilder();

        solve(0,0,m,n,ans,visited, path);

        return ans;
    }
}