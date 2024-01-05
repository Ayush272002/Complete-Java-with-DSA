public class Main {
    public static void main(String[] args) {
        kQueues q = new kQueues(6,3);
        q.enqueue(2,1);
        q.enqueue(9,2);
        q.enqueue(3,1);
        q.enqueue(7,2);
        q.enqueue(98,3);
        q.enqueue(79,3);
        q.print();
        q.dequeue(1);
        q.enqueue(80,3);
        q.print();
    }
}
