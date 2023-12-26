class Solution {

    ListNode getMid(ListNode head)
    {
        ListNode slow= head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null) return true;


        ListNode mid = getMid(head);

        //reverse list after middle
        ListNode temp = mid.next;

        mid.next = reverse(temp);

        //compare both halves

        ListNode head1 = head;
        ListNode head2 = mid.next;

        while(head2 != null)
        {
            if(head1.val != head2.val) return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        //making the list as before
        temp = mid.next;
        mid.next = reverse(temp);

        return true;
    }
}