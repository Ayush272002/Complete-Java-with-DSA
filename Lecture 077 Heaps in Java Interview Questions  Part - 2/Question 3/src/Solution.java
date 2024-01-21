import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        //step 1: insert all the elements into the queue
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                minHeap.add(node.val);
                node = node.next;
            }
        }

        ListNode ans = new ListNode(-1);
        ListNode ptr = ans;
        while (!minHeap.isEmpty())
        {
            ptr.next = new ListNode(minHeap.poll());
            ptr = ptr.next;
        }
        return ans.next;
    }
}
