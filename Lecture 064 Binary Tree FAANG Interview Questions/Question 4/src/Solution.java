import java.util.*;

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Map<Integer, Integer> topNode = new TreeMap<>(); //paired as HD, node.data
        Queue<MyPair> q = new LinkedList<>();

        q.add(new MyPair(root, 0));

        while(!q.isEmpty())
        {
            MyPair temp = q.poll();

            Node frontNode = temp.node;
            int hd = temp.position; //hd means horizontal distance

            //if one value is present for a HD, then do nothing
            if (!topNode.containsKey(hd))
                topNode.put(hd, frontNode.data);

            if(frontNode.left != null)
                q.add(new MyPair(frontNode.left, hd-1));

            if(frontNode.right != null)
                q.add(new MyPair(frontNode.right, hd+1));
        }
        for (Map.Entry<Integer, Integer> entry : topNode.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}