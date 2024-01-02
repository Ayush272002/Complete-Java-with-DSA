public class NStack {
    int[] arr;
    int[] top;
    int[] next;
    int n, s;
    int freeSpot;

    NStack(int N, int S)
    {
        this.n = N;
        this.s = S;
        this.arr = new int[s];
        this.top = new int[n];
        this.next = new int[s];

        //top initialise
        for (int i = 0; i < n; i++) {
            top[i] = -1;
        }

        //top initialise
        for (int i = 0; i < s; i++) {
            next[i] = i+1;
        }

        //update last position of index
        next[s-1] = -1;

        //initialise freeSpot
        freeSpot = 0;
    }

    //pushes X into the Mth stack, returns true, if it gets pushed otherwise false
    boolean push(int x, int m)
    {
        //check for overflow
        if(freeSpot == -1) return false;

        //find index
        int index = freeSpot;

        //update freeSpot
        freeSpot = next[index];

        //insert element into array
        arr[index] = x;

        //update next
        next[index] = top[m-1];

        //update top
        top[m-1] = index;

        return true;
    }

    //Pops top element from the Mth stack. Returns -1 if the stack is empty
    int pop(int m)
    {
        //check for empty stack
        if(top[m-1] == -1) return -1;

        //reverse the statements from the pop
        int index = top[m-1];
        top[m-1] = next[index];
        next[index] = freeSpot;
        freeSpot = index;
        return arr[index];
    }
}
