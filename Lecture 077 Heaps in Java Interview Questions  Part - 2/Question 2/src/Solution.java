import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        // Write your code here.
        PriorityQueue<Info> minHeap = new PriorityQueue<>(Comparator.comparingInt(Info -> Info.data));

        //step 1: insert all the elements in the heap

        for (int i = 0; i < K; i++) {
            Info temp = new Info(arr[i][0] , i , 0);
            minHeap.add(temp);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        //step 2 :

        while(!minHeap.isEmpty())
        {
            Info temp = minHeap.poll();
            ans.add(temp.data);

            int row = temp.row;;
            int col = temp.column;

            if(col+1 < arr[row].length)
            {
                Info next = new Info(arr[row][col+1], row , col);
                minHeap.add(next);
            }
        }

        return ans;
    }
}