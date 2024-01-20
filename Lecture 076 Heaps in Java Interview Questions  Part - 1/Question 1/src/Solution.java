import java.util.Comparator;
import java.util.PriorityQueue;

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here

        //to implement max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        //step 1
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        //step 2
        for (int i = k; i <= r; i++) {
           if(!pq.isEmpty() && arr[i] < pq.peek())
           {
               pq.poll();
               pq.add(arr[i]);
           }
        }

        //ans = pq top
        if(!pq.isEmpty()) return pq.peek();
        else return -1;
    }
}


/*
Algo
approach 1:
step 1 : sort the array - O(n log n) using heap sort
step 2 : ans = arr[k-1] - O(1)
Tc - O(n log n)

approach 2:
step 1: create max heap for fist k elements
step 2: for rest elements, if element < heap top
then pop from heap and push into the heap
ans = heap top
 */
