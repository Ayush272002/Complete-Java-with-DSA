import java.util.ArrayList;
import java.util.List;

public class OptimisedSol //using morris Traversal
{

    void inOrder(TreeNode root, List<Integer> ans)
    {
        TreeNode cur, pre;

        if(root == null) return;

        cur = root;

        while(cur != null)
        {
            if(cur.left == null)
            {
                ans.add(cur.val);
                cur =cur.right;
            }
            else
            {
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;

                if(pre.right == null)
                {
                    pre.right = cur;
                    cur =cur.left;
                }
                else
                {
                    pre.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans.get(k-1);
    }
}
