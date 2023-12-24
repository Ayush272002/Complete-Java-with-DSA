public class Main {
    public static void main(String[] args) {
        Solution s= new Solution();
        s.insertAtStart(6);
        s.insertAtStart(7);
        s.insertAtStart(8);
        s.insertAtStart(6);
        s.print();
        s.deleteDuplicates(s.head);
        s.print();
        s.insertAtStart(7);
        s.print();
        s.deleteDuplicates(s.head);
        s.print();
    }
}
