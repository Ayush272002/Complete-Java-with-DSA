import java.util.LinkedList;

public class Solution
{
    private static void inOrder(Node root, LinkedList<Integer> arr)
    {
        if(root == null) return;

        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    private static void preOrder(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void toMinHeap(Node root, LinkedList<Integer> arr)
    {
        if(root == null) return;

        root.data = arr.removeFirst();

        toMinHeap(root.left, arr);
        toMinHeap(root.right, arr);
    }
    public static void convertToMinHeap(Node root)
    {
        LinkedList<Integer> arr = new LinkedList<>();
        inOrder(root, arr);

        int index = 0;
        toMinHeap(root, arr);
    }


    public static void main(String[] args)
    {

        // BST formation
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        System.out.print(
                "Preorder Traversal Before Conversion :"
                        + "\n");
        preOrder(root);

        // Function call
        convertToMinHeap(root);

        System.out.print(
                "\nPreorder Traversal After Conversion :"
                        + "\n");
        preOrder(root);
    }
}
