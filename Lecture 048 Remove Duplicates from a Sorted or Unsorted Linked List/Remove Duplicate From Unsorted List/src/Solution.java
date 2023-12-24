import java.util.HashMap;
import java.util.Map;

public class Solution {

    ListNode head;

    public void print()
    {
        ListNode temp = head;
        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtStart(int data)
    {
        ListNode temp = new ListNode(data);
        temp.next = head;
        head = temp;
    }
    public ListNode deleteDuplicates(ListNode head)
    {
        if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        Map<Integer , Boolean> visited = new HashMap<>();

        while(curr != null)
        {
            if (visited.containsKey(curr.data))
            {
                prev.next =curr.next;
            }
            else
                visited.put(curr.data,true);

            prev = curr;
            curr =curr.next;
        }
        return head;
    }
}
