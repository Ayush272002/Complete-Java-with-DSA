import java.util.*;

class Solution {

    //create mapping and return target node
    private static Node createParentMapping(Node root, int target, Map<Node, Node> nodeToParent)
    {
        Node res = null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        //root doesnt have any parent
        nodeToParent.put(root,null);

        //level order traversal
        while(!q.isEmpty())
        {
            Node front = q.poll();

            if(front.data == target) res = front;

            if(front.left != null)
            {
                nodeToParent.put(front.left, front);
                q.add(front.left);
            }

            if(front.right != null)
            {
                nodeToParent.put(front.right, front);
                q.add(front.right);
            }
        }
        return res;
    }

    static int burnTree(Node root, Map<Node, Node> nodeToParent)
    {
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        visited.put(root,true);

        int ans = 0;
        while(!q.isEmpty())
        {
            boolean flag = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //process neighbouring node

                Node front = q.poll();

                if (front.left != null && visited.get(front.left) == null) {
                    flag = true;
                    q.add(front.left);
                    visited.put(front.left, true);
                }

                if (front.right != null && visited.get(front.right) == null) {
                    flag = true;
                    q.add(front.right);
                    visited.put(front.right, true);
                }

                if (nodeToParent.get(front) != null) {
                    Node parent = nodeToParent.get(front);
                    if (visited.get(parent) == null) {
                        flag = true;
                        q.add(parent);
                        visited.put(parent, true);
                    }
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
    public static int minTime(Node root, int target)
    {
        // Your code goes here

        //step 1 : create nodeToParent mapping
        //step 2 : find target node
        //step 3 : burn the tree in min time


        Map<Node, Node> nodeToParent = new HashMap<>();

        Node targetNode = createParentMapping(root, target, nodeToParent);
        if(targetNode == null) return 0;

        return burnTree(targetNode, nodeToParent);


    }
}
