import java.util.Stack;

class Solution {
    private int[] nextSmallerElement(int[] arr, int n)
    {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];

        for(int i= n-1; i>=0 ; i--)
        {
            int curr = arr[i];
            while(s.peek() != -1 && arr[s.peek()] >= curr)
                s.pop();

            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

    private int[] prevSmallerElement(int[] arr, int n)
    {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];

        for(int i= 0; i<n ; i++)
        {
            int curr = arr[i];
            while(s.peek() != -1 && arr[s.peek()] >= curr)
                s.pop();

            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights, int n)
    {
        int[] next = nextSmallerElement(heights, n);

        int area = -1;
        int[] prev = prevSmallerElement(heights,n);

        for (int i = 0; i < n; i++) {
            int l = heights[i];
            if(next[i] == -1) next[i] = n;
            int b = next[i] - prev[i] - 1;
            int newArea = l * b;
            area = Math.max(area, newArea);
        }
        return area;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n==0) return 0;
        int m = matrix[0].length;

        int[][] M = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                M[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));  // Convert char to int
            }
        }
        
        //compute area for 1st row
        int area = largestRectangleArea(M[0],m);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //row update by adding previous row values
                if(M[i][j] != 0)
                    M[i][j] = M[i][j] + M[i-1][j];
                else
                    M[i][j] = 0;
            }

            //entire row is updated now
            area = Math.max(area, largestRectangleArea(M[i],m));
        }
        return area;
    }
}