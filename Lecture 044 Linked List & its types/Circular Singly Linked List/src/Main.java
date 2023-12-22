public class Main {
    public static void main(String[] args) {
        CircularSingly list = new CircularSingly();

        list.insertNode(5,3);
        list.print();

        list.insertNode(3,5);
        list.print();

        list.insertNode(5,7);
        list.print();

        list.insertNode(7,9);
        list.print();

        list.insertNode(5,6);
        list.print();

        list.insertNode(9,10);
        list.print();

        list.insertNode(3,4);
        list.print();

        list.deleteNode(5);
        list.print();

        list.deleteNode(99);
        list.print();
    }
}
