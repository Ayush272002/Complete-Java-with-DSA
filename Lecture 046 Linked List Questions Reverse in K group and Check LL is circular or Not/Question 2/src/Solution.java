public class Solution {
    static boolean isCircular(Node head)
    {
        if(head == null) return false;

        Node temp = head.next;
        while(temp != null && temp != head)
        {
            temp = temp.next;

        }

        if(temp == head) return true;

        return false;

    }
}
