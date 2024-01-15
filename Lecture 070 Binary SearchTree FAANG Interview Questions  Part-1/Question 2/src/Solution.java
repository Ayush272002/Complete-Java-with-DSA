import java.util.ArrayList;
import java.util.List;

class Solution {
    private void inOrder(Node root, List<Integer> ans)
    {
        if(root == null) return;

        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }
    public int kthSmallest(Node root, int k) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans.get(k-1);
    }
}