class Solution {
    int index =0;
    private TreeNode solve(int[] preOrder, TreeNode root, int min, int max)
    {
        if(index >= preOrder.length) return null;

        if(preOrder[index] < min || preOrder[index] > max) return null;

        root = new TreeNode(preOrder[index++]);
        root.left = solve(preOrder, root.left , min, root.val);
        root.right = solve(preOrder,root.right , root.val, max);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder)
    {
        int min = Integer.MIN_VALUE;
        int max= Integer.MAX_VALUE;
        return solve(preorder,null, min, max);
    }
}