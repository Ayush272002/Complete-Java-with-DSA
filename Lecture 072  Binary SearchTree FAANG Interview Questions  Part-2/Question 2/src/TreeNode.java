public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val)
    {
        this.val = val;
        left = right = null;
    }

    TreeNode(int val, TreeNode right, TreeNode left)
    {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
