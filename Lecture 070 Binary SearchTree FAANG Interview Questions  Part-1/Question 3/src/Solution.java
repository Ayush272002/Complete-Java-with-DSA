public class Solution
{
    MyPair predecessorSuccessor(Node root, int key)
    {
        //find key
        Node temp = root;
        int pre = -1, suc =-1;

        while(temp.data != key)
        {
            if(temp.data > key)
            {
                suc = temp.data;
                temp = temp.left;
            }
            else
            {
                pre = temp.data;
                temp = temp.right;
            }
        }

        //predecessor and successor

        //predecessor
        Node leftTree = temp.left;
        while(leftTree != null)
        {
            pre = leftTree.data;
            leftTree = leftTree.right;
        }

        //successor
        Node rightTree = temp.right;
        while(rightTree != null)
        {
            suc = rightTree.data;;
            rightTree = rightTree.left;
        }

        return new MyPair(pre, suc);
    }
}


//Time complexity -O(n)  Space complexity - O(1)
