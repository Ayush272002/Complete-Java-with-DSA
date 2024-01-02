public class QueueUsingArray {
    private final int[] arr;
    private int front;
    private int rear;
    private final int size;

    public QueueUsingArray(int size)
    {
        this .size = size;
        arr = new int[size];
        front = 0;
        rear = 0;
    }

    void enqueue(int data)
    {
        if(rear == size)
            System.out.println("Queue is full");
        else
        {
            arr[rear] = data;
            rear++;
        }
    }

    int dequeue()
    {
        int ans = arr[front];
        arr[front] = -1;
        front++;
        if(front == rear)
        {
             front = 0;
             rear = 0;
        }
        return ans;
    }

    int Front()
    {
        if(front == rear) return -1;
        else return arr[front];
    }

    boolean isEmpty()
    {
        if(front == rear) return true;
        else return false;
    }

    void print()
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
