import java.util.Stack;

public class Solution {
    void sortedInsert(Stack<Integer> stack, int num)
    {
        //base case
        if(stack.isEmpty() || stack.peek()< num) {
            stack.push(num);
            return;
        }

        int n = stack.pop();

        sortedInsert(stack,num);

        stack.push(n);
    }
    void sortStack(Stack<Integer> stack)
    {
        if(stack.isEmpty()) return;

        int num = stack.pop();

        //recursive call
        sortStack(stack);

        sortedInsert(stack, num);
    }
}
