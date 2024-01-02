public class Deque {
    int[] arr;
    int front;
    int rear;
    int size;

    Deque(int n)
    {
        this.size = n;
        arr = new int[size];
        front = rear = -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || ((rear + 1) % size == front);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    boolean pushFront(int x)
    {
        //check full or not
        if(isFull()) return false;

        else if(isEmpty())
            front = rear = 0;

        else if(front == 0 && rear != size-1)
            front = size -1;

        else
            front--;

        arr[front] = x;
        return true;

    }

    public boolean pushRear(int x)
    {
        //check full or not
        if(isFull()) return false;

        else if(isEmpty())
            front = rear = 0;

        else if(rear == size-1 && front !=0)
            rear = 0;

        else
            rear++;

        arr[rear] = x;
        return true;
    }

    int popFront()
    {
        if(isEmpty()) return -1;

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

    int popRear()
    {
        if(isEmpty()) return -1;

        int ans = arr[rear];
        arr[rear] =-1;

        if(front == rear)
            front = rear = -1;
        else if(rear == 0)   //to maintain cyclic nature
            rear = size-1;
        else
            rear--;
        return ans;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        else
            return arr[front];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        else
            return arr[rear];
    }
}
