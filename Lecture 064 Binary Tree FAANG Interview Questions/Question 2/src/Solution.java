import java.util.ArrayList;

class Solution
{
    ArrayList<Integer> traverseLeft(Node root, ArrayList<Integer> ans)
    {
        //base case
        if(root == null) return ans;
        if(root.left == null && root.right == null) return ans;

        ans.add(root.data);
        if(root.left != null) ans = traverseLeft(root.left , ans);
        else ans= traverseLeft(root.right, ans);

        return ans;
    }

    ArrayList<Integer> traverseLeaf(Node root, ArrayList<Integer> ans)
    {
        //base case
        if(root==null) return ans;

        //leaf node
        if(root.left == null && root.right == null) ans.add(root.data);

        ans = traverseLeaf(root.left, ans);
        ans = traverseLeaf(root.right , ans);

        return ans;
    }

    ArrayList<Integer> traverseRight(Node root, ArrayList<Integer> ans)
    {
        //base case
        if(root == null) return ans;
        if(root.left == null && root.right == null) return ans;

        if(root.right != null) ans = traverseRight(root.right, ans);
        else ans = traverseRight(root.left , ans);

        //adding ans
        ans.add(root.data);

        return ans;
    }
    ArrayList<Integer> boundary(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;

        ans.add(node.data);

        //left part
        ans = traverseLeft(node.left,ans);

        //traverse leaf node

        //left subtree
        ans = traverseLeaf(node.left , ans);

        //right subtree
        ans= traverseLeaf(node.right , ans);

        //traverse right
        ans = traverseRight(node.right, ans);

        return ans;
    }
}