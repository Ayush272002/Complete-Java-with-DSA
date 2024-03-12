import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference)
    {
        Map<Integer,Integer> dp = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < arr.length; i++)
        {
            int temp = arr[i] - difference;
            int tempAns = 0;

            //check ans exist for temp
            if(dp.containsKey(temp)) tempAns = dp.get(temp);

            //current ans update
            dp.put(arr[i], 1 + tempAns);

            //ans update
            ans = Math.max(ans,dp.get(arr[i]));
        }

        return ans;
    }
}