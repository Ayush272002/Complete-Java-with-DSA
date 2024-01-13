/*
for the data set
1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

the output should be

printing the level of order of traversal
1
3 5
7 11 17
In Order Traversal is
7 3 11 1 17 5
Pre Order Traversal is
1 3 7 11 5 17
Post Order Traversal is
7 11 3 17 5 1

 */

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        //creating a tree
        bt.buildTree();

        //level order traversal
        System.out.println("printing the level of order of traversal ");
        bt.levelOrderTraversal();

        //in Order traversal
        System.out.println("In Order Traversal is");
        bt.inOrderTraversal();

        //pre order traversal
        System.out.println("Pre Order Traversal is ");
        bt.preOrderTraversal();

        //post order traversal
        System.out.println("Post Order Traversal is");
        bt.postOrderTraversal();

       /* bt.buildTreeFromLevelOrder();
        bt.levelOrderTraversal();
        System.out.println("Number of Leaf Nodes are "+bt.noOfLeafNodes());*/
    }
}
