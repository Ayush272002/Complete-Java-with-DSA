import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr , int n)
    {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i= n-1; i>=0 ; i--)
        {
            int curr = arr.get(i);
            while(s.peek() >= curr)
                s.pop();

            ans.add(i, s.peek());
            s.push(curr);
        }
        return ans;
    }
}
