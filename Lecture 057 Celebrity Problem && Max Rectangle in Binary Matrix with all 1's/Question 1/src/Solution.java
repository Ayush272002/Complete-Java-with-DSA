import java.util.Stack;

public class Solution {
    int celebrity(int[][] M, int n)
    {
        Stack<Integer> s = new Stack<>();
        //step 1: push all elements in stack
        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while(s.size() > 1)
        {
            int a= s.pop();
            int b = s.pop();

            if(M[a][b] == 1)
                s.push(b);
            else
                s.push(a);
        }

        int candidate = s.peek();
        //single element in stack is potential celebrity
        boolean rowCheck = false;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if(M[candidate][i] ==0) zeroCount++;
        }

        //check all zeros
        if(zeroCount == n) {
            rowCheck = true;
        }

        //column check
        boolean colCheck = false;
        int oneCount = 0 ;
        for (int i = 0; i < n; i++) {
            if(M[i][candidate] == 1 ) oneCount++;
        }

        //check for 1s it will be 1 less
        if(oneCount == n-1)
        {
            colCheck = true;
        }

        if(rowCheck && colCheck)
            return candidate;
        else return -1;
    }
}
