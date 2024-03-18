import java.util.Arrays;
import java.util.Comparator;

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job[] arr, int n)
    {
        // Your code here
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });

        int maxDeadline = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            maxDeadline = Math.max(maxDeadline,arr[i].deadline);
        }

        int[] schedule = new int[maxDeadline+1];
        Arrays.fill(schedule,-1);

        int count = 0;
        int maxProfit = 0;
        for (int i = 0; i < n; i++)
        {
            int currProfit = arr[i].profit;
            int currJobId = arr[i].id;
            int currDeadline = arr[i].deadline;

            for (int k = currDeadline; k > 0; k--)
            {
                if(schedule[k] == -1)
                {
                    count++;
                    maxProfit += currProfit;
                    schedule[k] = currJobId;
                    break;
                }
            }
        }

        return new int[]{count,maxProfit};
    }
}