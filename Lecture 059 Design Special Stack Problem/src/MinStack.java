import java.util.ArrayList;

class MinStack {
    private Node head;
    ArrayList<Integer> min;
    int mini = Integer.MAX_VALUE;

    public MinStack() {
        min = new ArrayList<>();
    }

    public void push(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        mini = Math.min(mini, val);
        min.add(mini);
    }

    public void pop() {
        if(head == null) return;

        head = head.next;
        if (!min.isEmpty()) {
            int index = min.size() - 1;
            min.remove(index);

            // Update mini to the new minimum value
            if (index > 0)
                mini = min.get(index - 1);
            else
                mini = Integer.MAX_VALUE;

        }
    }

    public int top() {
        if(head == null) return -1;

        return head.data;
    }

    public int getMin() {
        /*if(head == null)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        Node temp = head;
        int min = temp.data;

        while(temp != null)
        {
            min = Math.min(min, temp.data);
            temp = temp.next;
        }
        return min;*/
        return mini;   //complexity O(1)
    }
}
