class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    static MyPair solve(Node root)
    {
        //base case
        if(root == null) return new MyPair(0,0);

        MyPair left = solve(root.left);
        MyPair right = solve(root.right);

        MyPair res = new MyPair();
        res.first = root.data + left.second + right.second;
        res.second = Math.max(left.first, left.second) + Math.max(right.first, right.second);

        return res;
    }
    static int getMaxSum(Node root)
    {
        // add your code here
        MyPair pair = solve(root);

        return Math.max(pair.first, pair.second);
    }
}