import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Tree
{
    public ArrayList<Integer> diagonal(Node root)
    {
        //add your code here.
        ArrayList<Integer> diagonalVal = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            Node temp = q.poll();

            while(temp != null)
            {
                diagonalVal.add(temp.data);
                if(temp.left != null) q.add(temp.left);
                temp = temp.right;
            }
        }
        return diagonalVal;
    }
}
