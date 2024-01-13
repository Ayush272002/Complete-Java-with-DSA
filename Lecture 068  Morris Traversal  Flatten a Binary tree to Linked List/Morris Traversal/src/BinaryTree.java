import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinaryTree {
    Node root;

    /* Function to traverse a 
    binary tree without recursion
    and without stack */
    void MorrisTraversalInOrder(Node root)  //LNR
    {
        Node current, pre;

        if (root == null) return;

        current = root;
        while (current != null)
        {
            if (current.left == null)
            {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else
            {
				/* Find the inorder
					predecessor of current
				*/
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

				/* Make current as right
				child of its
				* inorder predecessor */
                if (pre.right == null)
                {
                    pre.right = current;
                    current = current.left;
                }

				/* Revert the changes made
				in the 'if' part
				to restore the original
				tree i.e., fix
				the right child of predecessor*/
                else
                {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL
                 */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
    }

    void MorrisTraversalPreOrder(Node root)  //NLR
    {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null)
        {
            if (current.left == null)
            {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else
            {
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;


                if (pre.right == null)
                {
                    System.out.print(current.data + " ");
                    pre.right = current;
                    current = current.left;
                }

                else
                {
                    pre.right = null;
                    current = current.right;
                }
            }
        }
    }


    List<Integer> MorrisTraversalPostOrderGetter(Node root)  //LRN
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Node current, pre;
        current= root;

        while(current != null)
        {

            // If right child is null,
            // put the current node data
            // in ans Move to left child.
            if(current.right == null)
            {
                ans.add(current.data);
                current = current.left;
            }
            else
            {
                pre = current.right;
                while (pre.left != null && pre.left != current)
                    pre = pre.left;


                // If left child doesn't point
                // to this node, then put in ans
                // this node and make left
                // child point to this node
                if(pre.left == null)
                {
                    ans.add(current.data);
                    pre.left = current;
                    current = current.right;
                }

                // If the left child of inorder predecessor
                // already points to this node
                else
                {
                    pre.left = null;
                    current = current.left;
                }
            }
        }
        // reverse the ans
        Collections.reverse(ans);
        return ans;
    }

    void MorrisTraversalPostOrder(Node root)
    {
        List<Integer> ans = MorrisTraversalPostOrderGetter(root);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }


    // Driver Code
    public static void main(String[] args)
    {
		/* Constructed binary tree is
			 1
			/ \
		   2   3
		  / \
	     4   5
		*/
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.MorrisTraversalInOrder(tree.root);
        System.out.println();
        tree.MorrisTraversalPreOrder(tree.root);
        System.out.println();
        tree.MorrisTraversalPostOrder(tree.root);
    }
}