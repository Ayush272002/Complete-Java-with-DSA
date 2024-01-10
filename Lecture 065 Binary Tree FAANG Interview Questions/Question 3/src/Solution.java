import java.util.ArrayList;

class Solution
{
    int solve(Node root, int k, int count, ArrayList<Integer> path)
    {
        //base case
        if(root == null) return count;

        path.add(root.data);

        //left
        count = solve(root.left, k, count, path);

        //right
        count = solve(root.right, k, count, path);

        //check for k sum
        int size = path.size();
        int sum = 0;
        for(int i = size-1 ; i>0 ; i--)
        {
            sum += path.get(i);
            if(sum ==k)
                count++;
        }

        path.remove(path.size()-1);
        return count;
    }
    public int sumK(Node root,int k)
    {
        // code here
        ArrayList<Integer> path = new ArrayList<>();
        int count = 0;
        count = solve(root, k , count, path);
        return count;
    }
}