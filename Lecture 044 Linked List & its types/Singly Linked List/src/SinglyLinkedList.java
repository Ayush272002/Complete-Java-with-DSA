public class SinglyLinkedList
{
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

    public void insertAtStart(int data)
    {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void insertAtEnd(int data)
    {
        Node node = new Node(data);

        if(head == null)
            head = node;

        else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    public void insertAtPosition(int position, int data)   //indexed using 1 not 0
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
        temp.next = nodeToInsert;
    }

    public void print()
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

    public void deleteAtPosition(int position)    //indexed using 1 not 0
    {
        if (position == 1) {
            // deleting first or start node
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        else
        {
            Node curr = head;
            Node prev = null;

            for (int i = 0; i < position && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }

            if (curr != null)
            {
                // Update prev.next to skip the node to be deleted
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    // If prev is null, it means the first node is being deleted
                    head = curr.next;
                }
            }
            else
            {
                System.out.println("Invalid Position");
            }
        }
    }

    public void deleteUsingValue(int data) {
        Node curr = head;
        Node prev = null;

        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            // Update prev.next to skip the node to be deleted
            if (prev != null) {
                prev.next = curr.next;
            } else {
                // If prev is null, it means the first node is being deleted
                head = curr.next;
            }
        } else {
            System.out.println("Value not found");
        }
    }

}
