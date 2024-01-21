import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);


        int k = lists.length;
        if(k == 0) return null;

        for (int i = 0; i < k; i++) {
            if(lists[i] != null) minHeap.add(lists[i]);
        }

        ListNode head = null;
        ListNode tail = null;

        while(!minHeap.isEmpty())
        {

            ListNode top = minHeap.poll();

            if(top.next != null) minHeap.add(top.next);

            if(head == null)
            {
                //list is empty
                head = tail = top;
            }
            else
            {
                //insert at end
                tail.next = top;
                tail = top;
            }

        }
        return head;
    }
}
