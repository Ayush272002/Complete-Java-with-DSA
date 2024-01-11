import java.util.ArrayList;

class Solution
{
    boolean findPath(Node root,int node, ArrayList<Integer> path)
    {
        if(root == null) return false;

        //adding the data
        path.add(root.data);

        //if the node value is found
        if(root.data == node) return true;

        //search in the left and right subtree
        if(findPath(root.left, node, path) || findPath(root.right, node, path))return true;

        // required node does not lie either in the
        // left or right subtree of the current node
        // Thus, remove current node's value from
        // 'path' and then return false

        path.remove(path.size()-1);
        return false;

    }

    public int kthAncestor(Node root, int k, int node)
    {
        // Write your code here
        ArrayList<Integer> path = new ArrayList<>();
        findPath(root, node, path);

        int index = path.size() - k - 1;

        if (index >= 0 && index < path.size()) return path.get(index);
        else return -1; // Indicates that the kth ancestor doesn't exist
    }
}