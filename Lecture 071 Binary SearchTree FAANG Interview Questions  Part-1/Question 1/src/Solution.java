class Solution {
    private boolean isBST(Node root, long min, long max)
    {
        //base case
        if(root == null) return true;

       if(root.data > min && root.data < max)
       {
           boolean left = isBST(root.left, min, root.data);
           boolean right = isBST(root.right, root.data, max);

           return left && right;
       }
       else return false;
    }
    public boolean isValidBST(Node root)
    {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}