public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtStart(5);
        list.insertAtStart(10);
        list.insertAtStart(20);
        list.insertAtEnd(25);
        list.insertAtEnd(50);
        list.insertAtPosition(3,90);
        list.deleteAtPosition(3);
        list.print();
        System.out.println("==========");
        System.out.println(list.getLength());
    }
}
