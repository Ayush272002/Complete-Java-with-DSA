public class Solution {
    private int height(Node node)
    {
        if(node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        int ans = Math.max(left,right) +1;
        return ans;
    }
    int diameter(Node root)
    {
        //base case
        if(root == null) return 0;

        int op1 = diameter(root.left);
        int op2 = diameter(root.right);
        int op3=  height(root.left) + height(root.right) + 1;

        int ans = Math.max(op1 , Math.max(op2,op3));
        return ans;
    }
}


//Time complexity - O(n^2) Not a feasible solution
