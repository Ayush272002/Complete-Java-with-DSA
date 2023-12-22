public class Solution {

    int getLength(ListNode head)
    {
        int length =0;
        ListNode temp = head;

        while(temp!=null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    public ListNode middleNode(ListNode head) {
        int length = getLength(head);
        if(length==0) return null;
        int middle = (length/2) +1;

        ListNode pointer = head;
        for (int i = 0; i < middle-1; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }
}
