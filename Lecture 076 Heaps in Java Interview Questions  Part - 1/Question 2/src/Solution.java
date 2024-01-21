class Solution {
    int countNodes(Node root)
    {
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    boolean isCBT(Node root, int index, int count)
    {
        if(root == null) return true;

        if(index >= count) return false;

        else
        {
            boolean left = isCBT(root.left, 2*index +1 , count);
            boolean right = isCBT(root.right, 2*index +2, count);
            return left && right;
        }
    }

    boolean isMaxOrder(Node root) {
        //base case : leaf node
        if (root.left == null && root.right == null) return true;

        //only one child
        if (root.right == null) return root.data > root.left.data;
        else if(root.left != null)
        {
            //contains both child
            boolean left  = isMaxOrder(root.left);
            boolean right = isMaxOrder(root.right);
            return left && right && root.data > root.left.data && root.data > root.right.data;
        }
        return false;
    }
    boolean isHeap(Node tree)
    {
        // code here
        int index = 0;
        int totalCount = countNodes(tree);
        return isCBT(tree, index, totalCount) && isMaxOrder(tree);
    }
}

/*
Time complexity - O(n)
Space complexity - O(n)
 */