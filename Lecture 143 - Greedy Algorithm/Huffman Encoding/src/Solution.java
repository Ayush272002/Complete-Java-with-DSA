import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution
{
    private void traverse(Node root, ArrayList<String> ans, String temp)
    {
        //base case
        if(root == null) return;
        if(root.left == null && root.right == null)
        {
            ans.add(temp.toString());
            return;
        }

        traverse(root.left, ans, temp+"0");
        traverse(root.right, ans, temp+"1");

    }
    public ArrayList<String> huffmanCodes(String S, int[] f, int N)
    {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            if(a.data == b.data) return 1;
            return a.data-b.data;
        });
        for (int i = 0; i < N; i++)
        {
            Node temp = new Node(f[i]);
            pq.add(temp);
        }

        while(pq.size() > 1)
        {
            Node left = pq.poll();
            Node right = pq.poll();

            if(left != null && right != null)
            {
                Node newNode = new Node(left.data + right.data);
                newNode.left = left;
                newNode.right = right;
                pq.add(newNode);
            }
        }

        Node root = pq.poll();

        ArrayList<String> ans = new ArrayList<>();
        String temp = "";
        traverse(root,ans, temp);
        return ans;
    }
}