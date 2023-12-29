import java.util.Stack;

public class Solution {
    void solve(Stack<Integer> myStack, int x)
    {
        if(myStack.isEmpty())
        {
            myStack.push(x);
            return;
        }

        int num = myStack.pop();

        //recursive call
        solve(myStack , x);

        myStack.push(num);
    }
    Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x)
    {
        solve(myStack, x);
        return myStack;
    }
}
