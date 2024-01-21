import java.util.PriorityQueue;

class OptimisedSol
{
    public static int kthLargest(int N, int K, int[] Arr)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += Arr[j];
                if(pq.size() < K) pq.add(sum);
                else if(!pq.isEmpty())
                {
                    if(sum > pq.peek())
                    {
                        pq.poll();
                        pq.add(sum);
                    }
                }
            }
        }
        if(!pq.isEmpty()) return pq.peek();
        else return -1;
    }
}

/*
Space complexity - O(n)
Time complexity - O(N^2 log(K))

can be optimised using Kadane's algorithm, will see that further
 */