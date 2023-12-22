public class CircularSingly {
    Node tail;

    void print()
    {
        Node temp = tail;

        if(tail == null) {
            System.out.println("List is empty");
            return;
        }

        //need a do while loop as if contains just 1 value, while loop won't execute
        do
        {
            System.out.print(tail.data + " ");
            tail = tail.next;
        }
        while(tail != temp);

        System.out.println();
    }

    void insertNode(int element, int data)
    {
        if(tail == null)            //empty list
        {
            Node newNode = new Node(data);
            tail = newNode;
            newNode.next = newNode;
        }

        else            //non-empty list assuming the item is present in the list
        {
            Node curr =tail;

            while(curr.data != element)
                curr = curr.next;

            Node temp = new Node(data);
            temp.next = curr.next;
            curr.next = temp;
        }
    }

    void deleteNode(int value)
    {
        //empty list
        if(tail == null)
            System.out.println("List is empty");

        else
        {
            //non-empty
            //assuming the value is present in the linked list

            Node prev = tail;
            Node curr = prev.next;

            while (curr.data != value)
            {
                prev = curr;
                curr = curr.next;

                // Check if one full traversal is completed
                if (curr == tail.next) {
                    System.out.println("Value not found");
                    return;
                }
            }

            prev.next = curr.next;
            //one node linked list
            if(curr==prev) tail = null;
            //>=2 node linked list
            else if(tail==curr) tail=prev;
            curr.next = null;
        }
    }
}
