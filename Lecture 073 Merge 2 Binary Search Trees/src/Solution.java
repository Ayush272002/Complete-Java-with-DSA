import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void inOrder(TreeNode root, List<Integer> in)
    {
        if(root == null) return;
        inOrder(root.left, in);
        in.add(root.val);
        inOrder(root.right, in);
    }

    List<Integer> mergeList(List<Integer> list1, List<Integer> list2)
    {
        List<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        int k =0;

        while (i < list1.size() && j < list2.size())
        {
            if(list1.get(i) < list2.get(j)) ans.add(list1.get(i++));
            else ans.add(list2.get(j++));
        }

        while (i < list1.size())
        {
            ans.add(k++, list1.get(i));
            i++;
        }

        while(j < list2.size())
        {
            ans.add(k++, list2.get(j));
            j++;
        }

        return ans;
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

    public TreeNode mergeBST(TreeNode root1, TreeNode root2)
    {
        //Step 1: store in order
        List<Integer> bst1 = new ArrayList<>(), bst2 = new ArrayList<>();
        inOrder(root1, bst1);
        inOrder(root2,bst2);

        List<Integer> merged = mergeList(bst1, bst2);
        int s =0, e = merged.size();

        return inOrderToBst(s,e,merged);
    }
}
