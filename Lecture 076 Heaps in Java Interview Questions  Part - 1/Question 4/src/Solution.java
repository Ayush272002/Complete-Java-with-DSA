import java.util.PriorityQueue;

class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long[] arr, int n)
    {
        // your code here
        long cost = 0L;
        long a = 0L, b = 0L;

        //step 1 : create a min heap
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        while(pq.size() > 1)
        {
            a= pq.poll();
            if(!pq.isEmpty()) b = pq.poll();

            long sum = a+b;
            cost += sum;
            pq.add(sum);

        }
        return cost;
    }
}