import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> createBoard(int[][] board, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(board[i][j] == 1 ? 'Q' : '.');
            }
            result.add(row.toString());
        }
        return result;
    }

    void addSolution(int[][] board, List<List<String>> ans, int n)
    {
        ans.add(createBoard(board, n));
    }

    boolean isSafe(int row, int col, int[][] board , int n)
    {
        int x  = row, y = col;

        //check for same row
        while(y >= 0)
        {
            if(board[x][y] == 1) return false;
            y--;
        }

        x  = row;
        y = col;

        //check for diagonal

        while (x >= 0 && y >= 0)
        {
            if(board[x][y] == 1) return false;
            y--;
            x--;
        }


        x  = row;
        y = col;

        //check for lower diagonal

        while (x < n && y >= 0)
        {
            if(board[x][y] == 1) return false;
            y--;
            x++;
        }

        return true;
    }

    private void solve(int col, List<List<String>> ans, int[][] board, int n)
    {
        //base case when all columns are full
        if(col == n)
        {
            addSolution(board, ans, n);
            return;
        }

        //solve 1 case and rest upto recursion

        for (int row = 0; row < n; row++) {
            if(isSafe(row, col,board, n))
            {
                //if placing queen is safe
                board[row][col] = 1;
                solve(col+1, ans, board, n);

                //back track
                board[row][col] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n)
    {
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();

        solve(0 ,ans,board, n);
        return ans;
    }

}