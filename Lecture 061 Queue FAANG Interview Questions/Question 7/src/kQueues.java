public class kQueues {
     int n;
     int k;
     int[] front;
     int[] rear;
     int[] arr;
     int freeSpot;
     int[] next;

     public kQueues(int n , int k)
     {
          this.n = n;
          this.k = k;
          front = new int[k];
          rear = new int[k];
          for (int i = 0; i < k; i++) {
               front[i] = -1;
               rear[i] = -1;
          }

          next = new int[n];
          for (int i = 0; i < n; i++) {
               next[i] = (i+1);
          }
          next[n-1] = -1;

          arr = new int[n];
          freeSpot = 0;
     }

     void enqueue(int data ,int qn)
     {
          //overflow
          if(freeSpot == -1)
          {
               System.out.println("No empty space is available, Queue is full");
               return;
          }

          //find first free index
          int index = freeSpot;

          //update freeSpot
          freeSpot = next[index];

          //check whether first element
          if(front[qn - 1] == -1) front[qn-1] = index;
          else
          {
               //link new element to the previous element
               next[rear[qn-1]] = index;
          }

          //update next
          next[index] = -1;


          //update rear
          rear[qn-1] = index;

          //push element
          arr[index] = data;
     }

     int dequeue(int qn)
     {
          //check underflow
          if(front[qn-1] == -1)
          {
               System.out.println("Queue is empty");
               return -1;
          }

          //find index to pop
          int index = front[qn-1];

          //increment front
          front[qn-1] = next[index];

          //manage free slots
          next[index] = freeSpot;
          freeSpot = index;

          return arr[index];
     }

     void print()
     {
          for (int i = 0; i < arr.length; i++) {
               System.out.print(arr[i]+" ");
          }
          System.out.println();
     }
}
