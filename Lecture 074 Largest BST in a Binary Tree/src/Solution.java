class Solution
{
    static Info solve(Node root)
    {
        Info currNode;

        if(root == null) return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);

        Info left = solve(root.left);
        Info right = solve(root.right);


        if(left.isBST && right.isBST && (root.data > left.max && root.data < right.min))
            currNode = new Info(Math.max(root.data, right.max), Math.min(root.data, left.min) , true , left.size + right.size +1);

        else
            currNode = new Info(0, Integer.MAX_VALUE, false,Math.max(left.size, right.size));

        return currNode;
    }

    // Return the size of the largest subtree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return solve(root).size;
    }
}