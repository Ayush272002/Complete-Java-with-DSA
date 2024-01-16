import java.util.ArrayList;
import java.util.List;

class Solution {
    private void inOrderFunc(TreeNode root, List<Integer> inOrder)  //LNR
    {
        if(root == null) return;

        inOrderFunc(root.left, inOrder);
        inOrder.add(root.val);
        inOrderFunc(root.right, inOrder);

    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderFunc(root, inOrder);
        int sum;

        int low = 0, high = inOrder.size()-1;

        while (high > low)
        {
            sum = inOrder.get(low) + inOrder.get(high);
            if(sum == k) return true;

            if(sum < k) low++;
            if(sum > k) high--;
        }

        return false;
    }
}