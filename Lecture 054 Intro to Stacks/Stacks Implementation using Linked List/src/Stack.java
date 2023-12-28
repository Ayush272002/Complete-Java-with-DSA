public class Stack {
    private Node head;

    void push(int data)
    {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    void pop()
    {
        if(head == null)
        {
            System.out.println("Stack is empty");
            return;
        }

        head = head.next;
    }

    int peek()
    {
        if(head == null)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

    boolean isEmpty()
    {
        if(head == null) return true;
        return false;
    }

    public void print()
    {
        Node temp = head;
        if(head == null)
        {
            System.out.println("Stack is empty");
            return;
        }
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
