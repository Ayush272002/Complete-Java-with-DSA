import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    private Node root;
    public void buildTree() {
        root = buildTreeHelper();
    }

    private Node buildTreeHelper()
    {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter the data, -1 to be taken as null");
        int data = x.nextInt();

        if (data == -1) {
            return null;
        }

        Node current = new Node(data);

        System.out.println("Enter data for inserting in left of " + data);
        current.left = buildTreeHelper();

        System.out.println("Enter data for inserting in right of " + data);
        current.right = buildTreeHelper();

        return current;
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

    public void buildTreeFromLevelOrder()
    {
        Queue<Node> q = new LinkedList<>();

        System.out.println("Enter the data for the root");
        Scanner x = new Scanner(System.in);
        int data = x.nextInt();
        root = new Node(data);

        q.add(root);

        while(!q.isEmpty())
        {
            Node temp = q.poll();

            System.out.println("Enter the left node for : "+temp.data);
            int leftData = x.nextInt();

            if(leftData != -1)
            {
                temp.left = new Node(leftData);
                q.add(temp.left);
            }

            System.out.println("Enter the right node for : "+temp.data);
            int rightData = x.nextInt();

            if(rightData != -1)
            {
                temp.right = new Node(rightData);
                q.add(temp.right);
            }
        }
    }

    private int inOrder(Node root, int count)
    {
        //base case
        if(root == null) return count;

        count = inOrder(root.left , count);

        //leaf node
        if(root.left == null && root.right == null)
            count++;

        count = inOrder(root.right , count);

        return count;
    }

    public int noOfLeafNodes()
    {
        int count = 0;
        count = inOrder(root , count);
        return count;
    }
}
