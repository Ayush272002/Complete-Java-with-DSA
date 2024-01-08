import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while(!q.isEmpty())
        {
            int size = q.size();
            ArrayList<Integer> ans = new ArrayList<>(size);

            //level process
            for (int i = 0; i < size; i++) {
                Node front = q.poll();

                if(front != null)
                {
                    //normal insert or reverse insert
                    if(leftToRight) ans.add(front.data);
                    else ans.add(0, front.data);

                    if(front.left != null) q.add(front.left);
                    if(front.right != null) q.add(front.right);
                }
            }

            //direction change
            result.addAll(ans);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
