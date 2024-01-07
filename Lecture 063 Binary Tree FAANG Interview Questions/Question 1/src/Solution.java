public class Solution  {
    int height(Node node)
    {
        if(node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        int ans = Math.max(left,right) +1;
        return ans;
    }
}
