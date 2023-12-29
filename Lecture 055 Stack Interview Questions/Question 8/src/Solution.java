import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);

            if(ch == '(')   st.push(ch);
            else
            {
                //ch is a closed brace
                if(!st.isEmpty() && st.peek() == '(')
                    st.pop();
                else st.push(ch);
            }

            //stack contain invalid expression now
        }
        return st.size();
    }
}