import java.util.*;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr.get(i);
            while (!s.isEmpty() && s.peek() >= curr)
                s.pop();

            if (s.isEmpty())
                ans.add(-1); // No smaller element found
            else
                ans.add(s.peek());

            s.push(curr);
        }
        Collections.reverse(ans); // Reverse the list to get the correct order
        return ans;
    }
}
