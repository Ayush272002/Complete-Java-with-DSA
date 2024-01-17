import java.util.ArrayList;
import java.util.List;

class Solution {
    private void inOrderFunc(TreeNode root, List<Integer> inOrder)  //LNR
    {
        if(root == null) return;

        inOrderFunc(root.left, inOrder);
        inOrder.add(root.val);
        inOrderFunc(root.right, inOrder);

    }
    public void flatten(TreeNode root)
    {
        List<Integer> inOrder = new ArrayList<>();
        inOrderFunc(root, inOrder);

        TreeNode newRoot = new TreeNode(inOrder.getFirst());
        TreeNode curr = newRoot;
        int n = inOrder.size();

        for (int i = 1; i < n; i++) {
            TreeNode temp = new TreeNode(inOrder.get(i));

            curr.left = null;
            curr.right = temp;
            curr = temp;
        }

        curr.left = null;
        curr.right = null;

    }
}
