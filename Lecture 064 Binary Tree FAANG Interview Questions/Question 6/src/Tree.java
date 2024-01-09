import java.util.*;

class Tree
{
    ArrayList<Integer> solveLeft(Node root, ArrayList<Integer> ans, int level)
    {
        //base case
        if(root==null) return ans;

        //we entered into a new level
        if(level == ans.size()) ans.add(root.data);

        //recursive call
        ans = solveLeft(root.left, ans, level+1);
        ans= solveLeft(root.right, ans, level+1);

        return ans;
    }

    ArrayList<Integer> solveRight(Node root, ArrayList<Integer> ans, int level)
    {
        //base case
        if(root==null) return ans;

        //we entered into a new level
        if(level == ans.size()) ans.add(root.data);

        //recursive call
        ans= solveRight(root.right, ans, level+1);
        ans = solveRight(root.left, ans, level+1);

        return ans;
    }

    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans = solveLeft(root, ans, 0);
        return ans;
    }

    ArrayList<Integer> rightView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        ans = solveRight(root, ans, 0);
        return ans;
    }

    ArrayList<Integer> rightViewNonRecursive(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;
        Map<Integer, Integer> rightNode = new TreeMap<>();
        Queue<MyPair> q = new LinkedList<>();

        q.add(new MyPair(root,0));

        while(!q.isEmpty())
        {
            MyPair temp = q.poll();
            Node right = temp.node;
            int distance = temp.position;

            rightNode.put(distance, right.data);

            if(right.left != null)
                q.add(new MyPair(right.left, distance+1));

            if(right.right != null)
                q.add(new MyPair(right.right, distance+1));
        }

        for(int key : rightNode.keySet())
            ans.add(rightNode.get(key));

        return ans;
    }
}