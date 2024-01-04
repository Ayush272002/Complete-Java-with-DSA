import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {
    public long[] printFirstNegativeInteger(long[] A, int N, int K)
    {
        Deque<Long> dq = new ArrayDeque<>();
        ArrayList<Long> ans = new ArrayList<>();

        //process first window of K size
        for (int i = 0; i < K; i++) {
           if(A[i] < 0)
               dq.addLast((long) i);
        }

        //store ans of first K sized window
        if(!dq.isEmpty())
            ans.add(A[Math.toIntExact(dq.peek())]);
        else
            ans.add(0L);

        //process for remaining windows

        for (int i = K; i < N; i++) {

            //removal
            if(!dq.isEmpty() && i - dq.peek() >= K)
                dq.removeFirst();
            //addition
            if(A[i] <0)
                dq.addLast((long) i);

            //ans store
            if(!dq.isEmpty())
                ans.add(A[Math.toIntExact(dq.peek())]);
            else
                ans.add(0L);
        }

        long[] Ans = new long[ans.size()];
        for (int i = 0; i < Ans.length; i++)
            Ans[i] = ans.get(i);

        return Ans;
    }
}
