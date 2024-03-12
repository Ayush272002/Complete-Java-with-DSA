import java.util.HashMap;
import java.util.Map;

class BottomUpApproach
{
    public int longestArithSeqLength(int[] nums)
    {
        int n = nums.length;
        if(n <= 2) return n;

        int ans = 2;
        @SuppressWarnings("unchecked") // Suppressing unchecked warning for the map
        Map<Integer,Integer>[] dp = new Map[n];
        dp[0] = new HashMap<>();

        for (int i = 1; i < n; i++)
        {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++)
            {
                int diff = nums[i] - nums[j];
                int count = 1;

                //check if ans is already present
                if(dp[j].containsKey(diff)) count = dp[j].get(diff);

                dp[i].put(diff,count + 1);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }

        return ans;
    }
}