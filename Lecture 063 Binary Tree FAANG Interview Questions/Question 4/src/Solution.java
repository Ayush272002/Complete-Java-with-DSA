public class Solution {
    boolean isIdentical(Node root1, Node root2)
    {
        //base case
        if(root1 == null && root2 == null) return true;

        if(root1 == null && root2 != null) return false;

        if(root1 != null && root2 == null) return false;


        boolean left = isIdentical(root1.left, root2.left);
        boolean right = isIdentical(root1.right, root2.right);

        boolean value = root1.data == root2.data;

        return left && right && value;

    }
}
