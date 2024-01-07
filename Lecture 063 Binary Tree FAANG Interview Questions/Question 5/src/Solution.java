public class Solution {
    int sum(Node root)
    {
        if(root == null) return 0;

        return root.data + sum(root.left) + sum(root.right);
    }
    boolean isSumTree(Node root)
    {
        if(root == null) return true;

        if(root.left == null && root.right == null) return true;

        boolean case1 = root.data == sum(root.left) + sum(root.right);

        return case1 && isSumTree(root.left) && isSumTree(root.right);
    }
}
