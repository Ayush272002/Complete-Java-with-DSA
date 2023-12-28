public class Stack {
    int[] arr;
    int top;
    int size;

    Stack(int size)
    {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int data)
    {
        if((size - top) >1)
        {
            top++;
            arr[top] = data;
        }
        else
            System.out.println("Stack overflow");
    }

    void pop()
    {
        if(top >= 0)
        {
            top --;
        }
        else
            System.out.println("Stack underflow");
    }

    int peek()
    {
        if(top >=0 )
            return arr[top];
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    boolean isEmpty()
    {
        if(top == -1) return true;

        return false;
    }
}
