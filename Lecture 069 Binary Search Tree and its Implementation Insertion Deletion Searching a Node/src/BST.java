import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {
    private Node root = null;

    private Node insertIntoBST(Node root, int data)
    {
        //base case
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data > root.data)
        {
            //insert in right part
            root.right = insertIntoBST(root.right, data);
        }
        else
        {
            //insert in left part
            root.left = insertIntoBST(root.left, data);
        }
        return root;
    }

    public void takeInput()
    {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter the data");
        int data = x.nextInt();

        while(data != -1)
        {
            root = insertIntoBST(root, data);
            System.out.println("Enter the data");
            data = x.nextInt();
        }
    }

    public void levelOrderTraversal()      //Breadth First Search
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);        //a separator

        while(!q.isEmpty())
        {
            Node temp = q.poll();

            if(temp == null)  //old level is traversed completely
            {
                System.out.println();
                if(!q.isEmpty())    //queue still has some child
                    q.add(null);
            }
            else
            {
                System.out.print(temp.data + " ");
                if(temp.left != null)
                    q.add(temp.left);

                if(temp.right != null)
                    q.add(temp.right);
            }
        }
    }

    public void inOrderTraversal()     //LNR
    {
        inOrderTraversalHelper(root);
        System.out.println();
    }

    private void inOrderTraversalHelper(Node root)
    {
        //base case
        if(root == null) return;

        inOrderTraversalHelper(root.left);
        System.out.print(root.data + " ");
        inOrderTraversalHelper(root.right);
    }

    public void preOrderTraversal()     //NLR
    {
        preOrderTraversalHelper(root);
        System.out.println();
    }

    private void preOrderTraversalHelper(Node root)
    {
        //base case
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrderTraversalHelper(root.left);
        preOrderTraversalHelper(root.right);
    }

    public void postOrderTraversal()    //LRN
    {
        postOrderTraversalHelper(root);
        System.out.println();
    }

    private void postOrderTraversalHelper(Node root)
    {
        //base case
        if(root == null) return;

        postOrderTraversalHelper(root.left);
        postOrderTraversalHelper(root.right);
        System.out.print(root.data + " ");
    }
    private boolean searchHelper(Node root, int val)
    {
        //base case
        if(root == null) return false;
        if(root.data == val) return true;

        if(val > root.data) return searchHelper(root.right, val);
        else return searchHelper(root.left, val);
    }

    public boolean searchInBst(int val)
    {
        return searchHelper(root, val);
    }

    private boolean searchInBstIterativelyHelper(Node root, int val)
    {
        Node temp = root;

        while(temp != null)
        {
            if(temp.data == val) return true;

            if(val > temp.data) temp = temp.right;
            else temp = temp.left;
        }
        return false;
    }

    public boolean searchInBstIteratively(int val)
    {
        return searchInBstIterativelyHelper(root, val);
    }

    public Node minVal()
    {
        Node temp = root;

        while(temp.left != null)
            temp = temp.left;

        return temp;
    }

    private Node minVal(Node root)
    {
        Node temp = root;

        while(temp.left != null)
            temp = temp.left;

        return temp;
    }

    public Node maxVal()
    {
        Node temp = root;

        while (temp.right != null)
            temp= temp.right;

        return temp;
    }

    private int pre, suc;
    private void inOrderPredecessorAndSuccessorHelper(Node root, int val)
    {
        if (root != null)
        {
            if (root.data == val)
            {
                // go to the right most element in the left subtree, it will the
                // predecessor.
                if (root.left != null)
                {
                    Node t = root.left;
                    while (t.right != null)
                        t = t.right;

                    pre = t.data;
                }
                if (root.right != null)
                {
                    // go to the left most element in the right subtree, it will
                    // the successor.
                    Node t = root.right;
                    while (t.left != null)
                        t = t.left;

                    suc = t.data;
                }
            }
            else if (root.data > val)
            {
                // we make the root as successor because we might have a
                // situation when value matches with the root, it won't have
                // right subtree to find the successor, in that case we need
                // parent to be the successor
                suc = root.data;
                inOrderPredecessorAndSuccessorHelper(root.left, val);
            }
            else if (root.data < val)
            {
                // we make the root as predecessor because we might have a
                // situation when value matches with the root, it won't have
                // left subtree to find the predecessor, in that case we need
                // parent to be the predecessor.
                pre = root.data;
                inOrderPredecessorAndSuccessorHelper(root.right, val);
            }
        }
    }

    public void inOrderPredecessorAndSuccessor(int val) {
        inOrderPredecessorAndSuccessorHelper(root,val);
        System.out.println("Pre is "+ pre);
        System.out.println("Suc is "+ suc);
    }

    private Node deleteFromBstHelper(Node root, int val)
    {
        //base case
        if(root ==null) return root;

        if(root.data == val)
        {
            //0 child
            if(root.left == null && root.right == null)
            {
                root = null;
                return null;
            }

            //1 child
            //left child
            if(root.left != null && root.right == null)
            {
                 Node temp = root.left;
                 root = null;
                 return temp;
            }

            //right child
            if(root.left == null && root.right != null)
            {
                Node temp = root.right;
                root = null;
                return temp;
            }

            //2 child
            if(root.left != null && root.right != null)
            {
                int min = minVal(root.right).data;

                root.data = min;
                root.right = deleteFromBstHelper(root.right, min);
                return root;
            }
        }
        else if(root.data > val)
        {
            //left part
            root.left = deleteFromBstHelper(root.left,val);
            return root;
        }
        else
        {
            //right part
            root.right = deleteFromBstHelper(root.right,val);
            return root;
        }
        return root;
    }

    public void deleteFromBst(int val)
    {
        root = deleteFromBstHelper(root,val);
    }
}
