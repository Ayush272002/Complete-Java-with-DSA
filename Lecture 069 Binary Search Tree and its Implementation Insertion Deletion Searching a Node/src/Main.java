import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.takeInput();
        System.out.println("Printing the bst");
        tree.levelOrderTraversal();
        System.out.println("Printing in Order");
        tree.inOrderTraversal();
        System.out.println("Printing pre order");
        tree.preOrderTraversal();
        System.out.println("Printing post order");
        tree.postOrderTraversal();


        /*tree.takeInput();
        System.out.println("Printing again");
        tree.levelOrderTraversal();*/

        /*Scanner x = new Scanner(System.in);
        System.out.println("Enter the vale which u want to search");
        int val = x.nextInt();

        System.out.println("Value present : "+ tree.searchInBst(val));
        System.out.println("Value present : "+ tree.searchInBstIteratively(val));*/


        System.out.println("Min val is "+ tree.minVal().data);
        System.out.println("Max val is "+tree.maxVal().data);
        tree.inOrderPredecessorAndSuccessor(30);

        /*System.out.println("Printing after deletion");
        tree.deleteFromBst(50);
        System.out.println("Printing the bst :");
        tree.levelOrderTraversal();
        System.out.println("Printing in Order");
        tree.inOrderTraversal();
        System.out.println("Printing pre order");
        tree.preOrderTraversal();
        System.out.println("Printing post order");
        tree.postOrderTraversal();*/
    }
}
