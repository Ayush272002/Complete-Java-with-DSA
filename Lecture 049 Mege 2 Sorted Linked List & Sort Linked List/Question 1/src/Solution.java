class Solution {

    static ListNode getMiddle(ListNode head)
    {
        if(head == null) return null;

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode Merge(ListNode a, ListNode b)
    {
        ListNode result = null;
        if(a == null && b == null) return null;
        if(a == null) return b;
        if(b == null) return a;

        if(a.val < b.val)
        {
            result = a;
            result.next = Merge(a.next, b);
        }
        else
        {
            result = b;
            result.next = Merge(a, b.next);
        }
        return result;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null) return head;

        ListNode middle = getMiddle(head);
        ListNode middleNext = middle.next;

        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(middleNext);

        return Merge(left,right);


    }
}