import java.util.Stack;

public class Solution {
    boolean findRedundantBrackets(String s)
    {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch =='(' || ch == '+' || ch == '-' || ch =='*' || ch == '/' || ch == '%')
                st.push(ch);
            else
            {
                if(ch ==')')
                {
                    boolean isRedundant = true;
                    while(st.peek() != '(')
                    {
                        char top = st.peek();
                        if(top == '+' || top == '-' || top == '*' || top =='/' || top =='%')
                            isRedundant = false;

                        st.pop();
                    }
                    if(isRedundant)
                        return true;
                    st.pop();
                }
            }
        }
        return false;
    }

}
