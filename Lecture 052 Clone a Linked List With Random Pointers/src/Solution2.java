//without map time complexity O(n) space complexity O(1)
class Solution2 {

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

        //step 2: cloned nodes add in btw original list
        Node originalNode = head;
        Node cloneNode = clone;

        while(originalNode != null && cloneNode != null)
        {
            Node next = originalNode.next;
            originalNode.next = cloneNode;
            originalNode = next;

            next = cloneNode.next;
            cloneNode.next = originalNode;
            cloneNode = next;
        }
        //step 3: copy random pointers
        Node curr = head;

        while(curr != null)
        {
            if(curr.next != null)
            {
                if(curr.random != null)
                {
                    curr.next.random = curr.random.next;
                }
            }
            else curr.next = curr.random;

            curr = curr.next.next;
        }

        //step 4; revert changes done in step 2
        originalNode = head;
        cloneNode = clone;
        while(originalNode != null && cloneNode != null)
        {
            originalNode.next =cloneNode.next;
            originalNode = originalNode.next;

            if(originalNode != null)  cloneNode.next = originalNode.next;
            cloneNode = cloneNode.next;
        }

        //step 5: return ans
        return clone;
    }
}