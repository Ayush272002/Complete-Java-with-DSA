import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {
    public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
        //step 1: put first half from the queue into the stack
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N / 2; i++) {
            st.push(q.poll());
        }

        //step 2: insert from stack to the queue
        while(!st.isEmpty())
        {
            q.add(st.pop());
        }

        //step 3: pop first half of queue and push it back
        for (int i = 0; i < N / 2; i++) {
            q.add(q.poll());
        }

        //step 4: put first half again in the stack
        for (int i = 0; i < N / 2; i++) {
            st.push(q.poll());
        }

        //step 5: main game
        while(!st.isEmpty())
        {
            q.add(st.pop());
            q.add(q.poll());
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            ans.add(q.poll());
        }
        return ans;
    }
}
