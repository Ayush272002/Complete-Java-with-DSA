import java.util.ArrayList;
import java.util.List;

public class GenericQueue<T> {
    private final List<T> arr;
    private int front;
    private int rear;
    private final int size;

    public GenericQueue(int size)
    {
        this.size = size;
        arr = new ArrayList<>(size);
        front = 0;
        rear = 0;
    }

    void enqueue(T data)
    {
        if(rear == size)
        {
            System.out.println("Queue is full");
        }
        else
        {
            arr.add(rear, data);
            rear++;
        }
    }

    T dequeue()
    {
        if(front == rear) return null;

        T ans = arr.get(front);
        arr.set(front, null);
        front++;// storing null value
        if(front == rear)  //checks if the array is empty so it will go the 0th index then
        {
            front = 0;
            rear = 0;
        }
        return ans;
    }

    T Front()
    {
        if(front == rear) return null;  //checks for empty queue
        else
            return arr.get(front);
    }

    boolean isEmpty()
    {
        if(front == rear) return true;
        else return false;
    }

    void print()
    {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}
