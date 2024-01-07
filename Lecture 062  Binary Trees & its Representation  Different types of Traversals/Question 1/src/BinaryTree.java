public class BinaryTree {
    int inOrder(BinaryTreeNode<Integer> root, int count)
    {
        //base case
        if(root == null) return count;

        count = inOrder(root.left , count);

        //leaf node
        if(root.left == null && root.right == null)
            count++;

        count = inOrder(root.right , count);

        return count;
    }
    int noOfLeafNodes(BinaryTreeNode<Integer> root)
    {
        int count = 0;
        count = inOrder(root, count);
        return count;
    }
}
