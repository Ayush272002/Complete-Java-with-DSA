public class TreeNode
{
    int data;
    int startInterval, endInterval;
    TreeNode left,right;

    public TreeNode(int startInterval, int endInterval)
    {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
    }
}
