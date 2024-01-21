import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums)
    {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        PriorityQueue<Info> minHeap = new PriorityQueue<>((a,b) -> a.data- b.data);

        //create a min heap using starting element of each list and tracking maxi and min
        int k = nums.size();
        for (int i = 0; i < k; i++) {
            int element = nums.get(i).get(0);
            maxi = Math.max(maxi, element);
            minHeap.add(new Info(element, i ,0));
        }

        if(!minHeap.isEmpty()) mini = minHeap.peek().data;
        int start = mini, end = maxi;

        //process ranges
        while(!minHeap.isEmpty())
        {
            //fetch mini
            Info temp = minHeap.poll();
            mini =temp.data;


            //range and ans update
            if(maxi - mini < end - start)
            {
                start = mini;
                end = maxi;
            }

            //next element exists
            int n = nums.get(temp.row).size();
            if(temp.column + 1 < n)
            {
                maxi = Math.max(maxi , nums.get(temp.row).get(temp.column+1));
                minHeap.add(new Info(nums.get(temp.row).get(temp.column+1), temp.row, temp.column+1));
            }

            //if next element doesn't exist then break
            else break;

        }
        //returning the ans
        return new int[]{start, end};
    }
}

/*
Time complexity - O(N * log(K))
Space complexity - O(K)
 */