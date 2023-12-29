import java.util.Stack;

public class Solution {
    void insertAtBottom(Stack<Integer> stack , int element)
    {
        //base case
        if(stack.empty()) {
            stack.push(element);
            return;
        }
        int num = stack.pop();

        insertAtBottom(stack, element);

        stack.push(num);
    }
    void reverseStack(Stack<Integer> stack)
    {
        //base case
        if(stack.isEmpty())
            return;

        int num = stack.pop();

        //recursive call
        reverseStack(stack);

        insertAtBottom(stack, num);
    }
}
