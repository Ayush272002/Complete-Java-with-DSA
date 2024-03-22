public class SegmentTree
{
    TreeNode root;
    public SegmentTree(int[] arr)
    {
        //create a tree using the array
        this.root = constructTree(arr,0,arr.length-1);
    }

    private TreeNode constructTree(int[] arr, int start, int end)
    {
        if(start == end)
        {
            //leaf node
            TreeNode leaf = new TreeNode(start,end);
            leaf.data = arr[start];
            return leaf;
        }

        //create new node with index you are at
        TreeNode node = new TreeNode(start,end);

        int mid = start + (end-start)/2;

        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display()
    {
        display(this.root);
    }

    private void display(TreeNode node)
    {
        String str = "";
        if(node.left != null)
        {
            str = str + "Interval = [" + node.left.startInterval + " - " + node.left.endInterval + " ] and data : " + node.left.data + " => ";
        }
        else
        {
            str += "No left child";
        }

        //for curr node
        str = str + "Interval = [ " + node.startInterval + " - " + node.endInterval + " ] and data : " + node.data + " <= ";

        if(node.right != null)
        {
            str = str + "Interval = [" + node.right.startInterval + " - " + node.right.endInterval + " ] and data : " + node.right.data;
        }
        else
        {
            str += "No right child";
        }
        System.out.println(str + '\n');

        //recursion
        if(node.left != null) display(node.left);
        if(node.right != null) display(node.right);

    }

    //qsi - query start index
    public int query(int qsi, int qei)
    {
        return query(this.root,qsi,qei);
    }

    private int query(TreeNode node, int qsi, int qei)
    {
        if(node.startInterval >= qsi && node.endInterval <= qei)
        {
            //node is completely lying inside the query
            return node.data;
        }
        else if(node.startInterval > qei || node.endInterval < qsi)
        {
            //completely outside no contribution
            return 0;
        }
        else
        {
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }

    public void update(int index, int value)
    {
        this.root.data = update(this.root,index,value);
    }
    private int update(TreeNode node, int index, int value)
    {
        if(index >= node.startInterval && index <= node.endInterval)
        {
            if(index == node.startInterval && index == node.endInterval)
            {
                node.data = value;
            }
            else
            {
                int leftAns = update(node.left,index,value);
                int rightAns = update(node.right,index,value);

                node.data = leftAns + rightAns;
            }
            return node.data;
        }

        return node.data;
    }
}
