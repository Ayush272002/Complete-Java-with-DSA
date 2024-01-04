import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q)
    {
        Queue<Integer> New = new LinkedList<>();

        //step1: fetch first half of the input queue into the new queue
        for (int i = 0; i < N / 2; i++) {
            New.add(q.poll());
        }

        //step 2: until the new queue isnt empty lets play the game
        while(!New.isEmpty())
        {
            q.add(New.poll());
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
