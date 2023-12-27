import java.util.HashMap;
import java.util.Map;

//time and space complexity both of order n

class Solution {

    private Node insertAtEnd(Node head, int val)
    {
        Node node = new Node(val);

        if(head == null)
            head = node;

        else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
        return head;
    }
    public Node copyRandomList(Node head) {

        //step 1: create a cloned list
        Node clone = null;
        Node temp = head;

        while(temp != null)
        {
            clone = insertAtEnd(clone, temp.val);
            temp = temp.next;
        }

        //step 2: create a map
        Map<Node , Node> oldToNew = new HashMap<>();

        Node originalNode = head;
        Node clonedNode = clone;

        while(originalNode != null && clonedNode != null)
        {
            oldToNew.put(originalNode,clonedNode);
            originalNode = originalNode.next;
            clonedNode= clonedNode.next;
        }
        originalNode = head;
        clonedNode = clone;

        while(originalNode != null)
        {
            clonedNode.random = oldToNew.get(originalNode.random);
            originalNode = originalNode.next;
            clonedNode= clonedNode.next;
        }
        
        return clone;

    }
}