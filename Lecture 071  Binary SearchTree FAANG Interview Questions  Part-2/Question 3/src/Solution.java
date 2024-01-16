import java.util.ArrayList;
import java.util.List;

public class Solution {

    private void inOrderFunc(TreeNode root, List<Integer> inOrder)  //LNR
    {
        if(root == null) return;

        inOrderFunc(root.left, inOrder);
        inOrder.add(root.val);
        inOrderFunc(root.right, inOrder);

    }

    TreeNode inOrderToBst(int s, int e, List<Integer> inOrder)
    {
        if(s>e) return null;

        int mid = (s+e)/2;
        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = inOrderToBst(s, mid-1, inOrder);
        root.right = inOrderToBst(mid+1, e, inOrder);
        return root;
    }
    TreeNode balanceBST(TreeNode root)
    {
        //Add your code here.
        List<Integer> inOrder = new ArrayList<>();
        inOrderFunc(root, inOrder);

        return inOrderToBst(0,inOrder.size()-1,inOrder);
    }
}
