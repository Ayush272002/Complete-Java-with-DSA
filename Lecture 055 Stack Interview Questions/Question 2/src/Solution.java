import java.util.Stack;

public class Solution {
    void solve(Stack<Integer> inputStack, int count, int size)
    {
        //base case
        if(count == size/2)
        {
            inputStack.pop();
            return;
        }

        int num = inputStack.pop();


        //recursion call
        solve(inputStack, count+1, size);

        //number push in the stack which was popped
        inputStack.push(num);
    }
    void deleteMiddle(Stack<Integer> inputStack, int N)
    {
        int count = 0;
        solve(inputStack, count, N);
    }
}
