class Solution
{
    public static void flatten(Node root)
    {
        //code here
        if(root == null) return;

        Node current , prev;

        current = root;

        while(current != null)
        {
           if(current. left != null)
           {
               prev = current.left;

               while(prev.right != null && prev != current)
                   prev = prev.right;

               if(prev.right == null)
               {
                   prev.right = current.right;
                   current.right = current.left;
                   current.left = null;
               }
           }

           //because currents right points to the currents right and after that currents left points to null check line 21. that's why cur = cur.right
            // otherwise in morris traversal we do cur = cur.left, here right pointer points to the same location as the left pointer.
           current = current.right;
        }
    }
}