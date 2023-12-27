public class Solution {

    private Node merge(Node l1, Node l2)
    {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Node result;

        if(l1.data < l2.data)
        {
            result = l1;
            result.bottom = merge(l1.bottom , l2);
        }
        else
        {
            result = l2;
            result.bottom = merge(l1 , l2.bottom);
        }
        result.next = null;
        return result;
    }
    public Node flatten(Node head)
    {
        //base case
        if(head == null || head.next == null) return head;

        head.next = flatten(head.next);

        //merge
        head = merge(head, head.next);

        return head;
    }
}
