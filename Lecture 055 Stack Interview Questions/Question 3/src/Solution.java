import java.util.Stack;

class Solution {
    boolean matches(char top, char ch)
    {
        if(
                (top == '(' && ch == ')') ||
                        (top == '[' && ch == ']') ||
                        (top == '{' && ch == '}')
        )
            return true;
        else return false;
    }
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            char ch  = arr[i];
            //if opening backed then push
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);

            //closing bracket
            else
            {
                if(!stack.isEmpty())
                {
                    char top = stack.peek();
                    if(matches(top , ch))
                    {
                        stack.pop();
                    }
                    else return false;
                }
                else return false;
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}