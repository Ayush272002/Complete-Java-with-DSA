public class Main {
    public static void main(String[] args) {
        GenericQueue<Integer> queue = new GenericQueue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(4);

        queue.print();

        System.out.println("===========");

        QueueUsingArray q  = new QueueUsingArray(2);
        q.enqueue(5);
        q.print();
        q.dequeue();
        System.out.println();
        q.print();


    }
}
