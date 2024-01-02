public class CircularQueue {
    private final int[] arr;
    private int front;
    private int rear;
    private final int size;

    CircularQueue(int n)
    {
        this.size = n;
        arr = new int[size];
        front = rear = -1;
    }

    //enqueues X into the queue. Returns true if it gets pushed into the stack otherwise false
    boolean enqueue(int value)
    {
        //to check whether queue is full
        if((front == 0 && rear == size -1) || ((rear + 1) % size == front))
        {
            System.out.println("Queue is full ");
            return false;
        }
        else if(front == -1)        //first element to push
            front = rear = 0;

        else if(rear == size -1 && front != 0)
            rear = 0;       //to maintain cyclic nature

        else
            rear++;
        //push inside the queue
        arr[rear] = value;
        return true;
    }

    int dequeue()
    {
        if(front == -1)         //check queue is empty
        {
            System.out.println("Queue is empty");
            return -1;
        }
        int ans = arr[front];
        arr[front] =-1;
        if(front == rear)
            front = rear = -1;
        else if(front == size -1)   //to maintain cyclic nature
            front = 0;
        else
            front++;
        return ans;
    }
}
