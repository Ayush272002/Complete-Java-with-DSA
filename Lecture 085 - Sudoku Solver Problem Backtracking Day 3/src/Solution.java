class Solution
{
    private boolean isSafe(int row, int col, char[][] board, int val)
    {
        for (int i = 0; i < board.length; i++) {

            //row check
            if(board[row][i] == (char) (val + '0')) return false;

            //col check
            if(board[i][col] ==(char) (val + '0')) return false;

            //check the 3 x 3 matrix

            if(board[3 *(row/3) + i/3][3*(col/3) + i%3] == (char) (val + '0'))
                return false;
        }

        return true;
    }
    boolean solve(char[][] board)
    {
        int n = board[0].length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                //cell empty
                if(board[row][col] == '.')
                {
                    for (int val = 1; val <= 9; val++) {
                        if(isSafe(row,col,board,val))
                        {
                            board[row][col] = (char)(val + '0');

                            //recursive call
                            boolean possibleFurther = solve(board);

                            if(possibleFurther) return true;
                            else
                            {
                                //backtrack
                                board[row][col] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board)
    {
        solve(board);
    }
}

/*
The expression char c = (char) (val + '0'); is converting the integer
value val to its corresponding character representation.
In Java, characters are represented as Unicode values, and the
characters '0' to '9' have consecutive Unicode values.

 Time complexity - 9^m (m - means no. of empty cell)
 Space complexity - O(1) in the recursive call stack we can count the no. of recursive call stack
 */