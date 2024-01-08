import java.util.*;

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<MyPair> q = new LinkedList<>();

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        q.add(new MyPair(root,0));

        while(!q.isEmpty())
        {
            MyPair temp = q.poll();
            Node temp_root = temp.node;
            int distance = temp.position;

            if(map.containsKey(distance))
            {
                ArrayList<Integer> al = map.get(distance);
                al.add(temp_root.data);
                map.put(distance , al);
            }
            else
            {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(temp_root.data);
                map.put(distance,al);
            }

            //if left child of temp_root exists, pushing it in
            //the queue with the horizontal distance.
            if(temp_root.left != null) q.add(new MyPair(temp_root.left,distance-1));

            //if right child of temp_root exists, pushing it in
            //the queue with the horizontal distance.
            if(temp_root.right != null) q.add(new MyPair(temp_root.right, distance+1));
        }

        //putting the map values in the result list
        for(Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet())
        {
            ArrayList<Integer> al = m.getValue();
            for (int i = 0; i < al.size(); i++) {
                ans.add(al.get(i));
            }
        }

        return ans;
    }
}