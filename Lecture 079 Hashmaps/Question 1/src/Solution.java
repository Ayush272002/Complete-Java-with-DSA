import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int maxFrequencyNumber(int n, int[] arr) {
        // Write your code here
        Map<Integer, Integer> count = new HashMap<>();

        int maxFreq = 0;
        int maxAns = 0;

        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i],0)+1);
            maxFreq = Math.max(maxFreq,count.get(arr[i]));
        }

        for (int i = 0; i < arr.length; i++) {
            if(maxFreq == count.get(arr[i]))
            {
                maxAns = arr[i];
                break;
            }
        }

        return maxAns;
    }

    public static void main(String[] args) {
        int ans = maxFrequencyNumber(13 , new int[]{2,12,2,11,-12,2,-1,2,2,11,12,2,-6});
        System.out.println(ans);
    }
}