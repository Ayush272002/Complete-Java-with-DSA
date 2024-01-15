import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private void inOrder(Node root, List<Integer> ans)
    {
        if(root == null) return;

        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }

    private boolean isSorted(List<Integer> ans, int n)
    {
        for (int i = 0; i < n-1 ; i++) {
            if(ans.get(i) > ans.get(i+1)) return false;
        }

        return true;
    }

    public boolean isValidBST(Node root)
    {
        List<Integer> ans = new ArrayList<>();

        inOrder(root, ans);
        return isSorted(ans, ans.size());
    }
}
