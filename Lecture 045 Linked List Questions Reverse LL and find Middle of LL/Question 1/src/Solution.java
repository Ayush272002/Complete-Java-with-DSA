public class Solution
{
    public static ListNode reverseList(ListNode head)
    {
        if(head == null || head.next==null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null)
        {
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public static ListNode reverseListUsingRecursion(ListNode head)
    {
        return reverse(head,null);
    }

    static ListNode reverse(ListNode curr, ListNode prev)
    {
        if(curr==null)
            return prev;

        ListNode forward = curr.next;
        curr.next = prev;
        return reverse(forward, curr);
    }
}