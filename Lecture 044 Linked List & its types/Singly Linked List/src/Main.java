public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtStart(3);
        list.insertAtPosition(1,22);
        list.deleteAtPosition(1);
        list.deleteUsingValue(7);

        list.print();
        System.out.println("===========");
        System.out.println(list.getLength());

    }
}