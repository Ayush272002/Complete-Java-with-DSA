import java.util.HashMap;
import java.util.Map;

public class Solution {
    boolean detectLoop(Node head)
    {
        if(head==null) return false;

        Map<Node, Boolean> visited = new HashMap<>();
        Node temp = head;
        while(temp != null)
        {
            //detect cycle
            if(visited.containsKey(temp) && visited.get(temp)) return true;

            visited.put(temp,true);

            temp = temp.next;
        }
        System.out.println("No looping");
        return false;
    }

    static Node floydDetectionLoop(Node head)
    {
        if(head==null)  return null;
        Node fast = head.next ;
        Node slow = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)  return slow;
        }
        return null;
    }

    static Node getStartingNode(Node head)
    {
        if(head == null) return null;
        Node intersection = floydDetectionLoop(head);
        Node slow = head;

        while (slow != intersection)
        {
            slow = slow.next;
            intersection = intersection.next;
        }
        return slow;
    }

    // above code is a lengthy way to detect the loop and the node
    //here is a simplified version
    public Node detectCycleWithHash(Node head) {

        // simple way to detect the starting node of the list using hashmap
        if(head==null)  return null;
        Map<Node, Boolean> visited = new HashMap<>();
        Node temp = head;
        while(temp != null)
        {
            //detect cycle
            if(visited.containsKey(temp) && visited.get(temp)) return temp;

            visited.put(temp,true);

            temp = temp.next;
        }
        return null;
    }

    //another method without using hash is
    public Node detectCycle(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                while(head!=slow)
                {
                    head=head.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    //to remove cycle
    public void removeLoop(Node head)
    {
        if(head==null) return;

        Node startOfLoop = detectCycle(head);
        Node temp = startOfLoop;

        while (temp.next != startOfLoop)
            temp = temp.next;

        temp.next = null;

    }

}
