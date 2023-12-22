public class DoublyLinkedList {
    private Node head;

    int getLength()
    {
        int length =0;
        Node temp = head;

        while(temp!=null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    void print()
    {
        Node temp = head;

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

    void insertAtStart(int data)
    {
        Node temp = new Node(data);
        temp.next = head;
        if(head!= null) head.prev=temp;
        head = temp;
    }

    void insertAtEnd(int data)
    {
        Node temp = new Node(data);

        if(head==null)
        {
            head = temp;
            return;
        }

        Node node = head;
        while(node.next != null)
            node = node.next;

        node.next = temp;
        temp.prev = node;
    }

    void insertAtPosition(int position, int data) //indexed using 1 not 0
    {
        if(position==1) {
            insertAtStart(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        if(temp.next == null) {
            insertAtEnd(data);
            return;
        }

        Node nodeToInsert = new Node(data);
        nodeToInsert.next = temp.next;
        temp.next.prev = nodeToInsert;
        temp.next = nodeToInsert;
        nodeToInsert.prev = temp;

    }

    void deleteAtPosition(int position)
    {
        if(position > getLength())
        {
            System.out.println("Invalid position ");
            return;
        }
        if (position == 1 && head != null) {
            // deleting the first node
            Node temp = head;
            if (temp.next != null) {
                temp.next.prev = null;
            }
            head = temp.next;
            temp.next = null;
        }
        else
        {
            Node curr = head;
            Node prev = null;
            // Traverse to the node at the specified position
            for (int i = 1; curr != null && i < position; i++) {
                prev = curr;
                curr = curr.next;
            }

            // Check if the specified position is valid
            if (curr != null) {
                curr.prev = null;
                if (prev != null) {
                    prev.next = curr.next;
                    if (curr.next != null) {
                        curr.next.prev = prev;
                    }
                    curr.next = null;
                }
            }
        }
    }



}
