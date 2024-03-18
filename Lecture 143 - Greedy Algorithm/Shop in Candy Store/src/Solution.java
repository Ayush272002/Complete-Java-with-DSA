import java.util.ArrayList;
import java.util.Arrays;

class Solution{
    static ArrayList<Integer> candyStore(int[] candies, int N, int K)
    {
        // code here
        Arrays.sort(candies);

        int mini = 0;
        int buy = 0;
        int free = N-1; 

        while(buy <= free)
        {
            mini += candies[buy];
            buy++;
            free -= K;
        }

        int maxi = 0;
        buy = N-1;
        free = 0;
        while(free <= buy)
        {
            maxi += candies[buy];
            buy--;
            free += K;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(mini);
        ans.add(maxi);
        return ans;
    }
}