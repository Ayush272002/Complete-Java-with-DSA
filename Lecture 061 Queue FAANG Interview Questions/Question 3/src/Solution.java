import java.util.Queue;
import java.util.Stack;

public class Solution {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        //step1: pop first k from queue and put it into stack
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            s.push(q.poll());
        }

        //step 2: fetch from stack and push it into the queue
        while(!s.isEmpty())
        {
            q.add(s.pop());
        }

        //step 3: fetch first (n-k) elements from the queue and insert it to the back
        int t = q.size() - k;
        for (int i = 0; i < t; i++) {
            q.add(q.poll());
        }
        return q;
    }
}
