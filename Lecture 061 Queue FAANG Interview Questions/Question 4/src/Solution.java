import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    String FirstNonRepeating(String A)
    {
        Map<Character, Integer> count = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            //increase count
            count.put(ch , count.getOrDefault(ch ,0) + 1);

            //push in queue
            q.add(ch);

            while(!q.isEmpty())
            {
                if(count.get(q.peek()) > 1)
                {
                    //repeating character popping
                    q.poll();
                }
                else
                {
                    //non-repeating character so push inside
                    ans.append(q.peek());
                    break;
                }
            }

            if(q.isEmpty())
                ans.append('#');
        }
        return ans.toString();
    }
}
