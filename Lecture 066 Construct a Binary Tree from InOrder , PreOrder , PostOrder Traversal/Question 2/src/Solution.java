import java.util.HashMap;

class Solution
{
    private Node buildTreePostIn(int[] inorder, int is, int ie, int[] postorder,
                                 int ps, int pe, HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        Node root = new Node(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        Node left = buildTreePostIn(inorder, is, ri-1, postorder, ps,
                ps+ri-is-1, hm);
        Node right = buildTreePostIn(inorder,ri+1, ie, postorder,
                ps+ri-is, pe-1, hm);
        root.left = left;
        root.right = right;
        return root;
    }
    //Function to return a tree created from postorder and inorder traversals.
    Node buildTree(int[] in, int[] post, int n) {
        // Your code here
        if (in == null || post == null || in.length != post.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<in.length;++i)
            hm.put(in[i], i);
        return buildTreePostIn(in, 0, in.length-1, post, 0,
                post.length-1,hm);
    }
}