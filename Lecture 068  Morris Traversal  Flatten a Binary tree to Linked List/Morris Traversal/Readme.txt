Algorithm
Benefits - Time complexity O(n) space complexity is O(1)

current = root
while(root != null)
if left not exist visit current
current = current.right

else
predecessor = find(current)
if(pred.right == null)
 pred.right = current;
 current = current.left

 else
 pred.right = null
 visit(current)
 current = current.right


 Using Morris Traversal, we can traverse the tree without using stack and recursion. The idea of Morris Traversal is based on Threaded Binary Tree. In this traversal, we first create links to Inorder successor and print the data using these links, and finally revert the changes to restore original tree.

 1. Initialize current as root
 2. While current is not NULL
    If the current does not have left child
       a) Print current’s data
       b) Go to the right, i.e., current = current->right
    Else
       a) Find rightmost node in current left subtree OR
               node whose right child == current.
          If we found right child == current
              a) Update the right child as NULL of that node whose right child is current
              b) Print current’s data
              c) Go to the right, i.e. current = current->right
          Else
              a) Make current as the right child of that rightmost
                 node we found; and
              b) Go to this left child, i.e., current = current->left