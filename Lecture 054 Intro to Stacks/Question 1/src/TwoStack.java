public class TwoStack {
    int[] arr;
    int top1, top2;
    int size;
    TwoStack(int s)
    {
        this.size = s;
        top1 = -1;
        top2 = s;
        arr = new int[size];
    }

    void push1(int num)
    {
        if((top2 - top1) > 1)  //at least 1 empty space
        {
            top1++;
            arr[top1] = num;
        }
        else
            System.out.println("Stack Overflow");
    }

    void push2(int num)
    {
        if((top2 - top1) > 1)  //at least 1 empty space
        {
            top2--;
            arr[top2] = num;
        }
        else
            System.out.println("Stack Overflow");
    }

    int pop1()
    {
        if(top1 >= 0)
        {
            int ans = arr[top1];
            arr[top1] = -1;
            top1--;
            return ans;
        }
        else return -1;
    }

    int pop2()
    {
        if(top1 <= size)
        {
            int ans = arr[top2];
            arr[top2] = -1;
            top2++;
            return ans;
        }
        else return -1;
    }

    void print()
    {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
