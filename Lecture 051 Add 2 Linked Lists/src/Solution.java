class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode curr  = ans;
        int carry =0;

        while(l1 != null || l2 != null || carry !=0)
        {
            int val1 =0;
            if(l1 != null) val1 = l1.val;

            int val2=0;
            if(l2 != null) val2 = l2.val;

            int sum = carry + val1 + val2;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return ans.next;
    }
}