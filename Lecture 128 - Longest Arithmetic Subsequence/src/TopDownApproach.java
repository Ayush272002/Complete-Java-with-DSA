import java.util.HashMap;
import java.util.Map;

class TopDownApproach
{
    private int solve(int index, int diff, int[] nums, Map<Integer,Integer>[] dp)
    {
        //backward check

        if(index < 0) return 0;
        if(dp[index].containsKey(diff)) return dp[index].get(diff);

        int ans = 0;
        for(int j = index-1; j >= 0; j--)
        {
            if(nums[index]- nums[j] == diff)
            {
                ans = Math.max(ans,1 + solve(j,diff,nums, dp));
            }
        }

        dp[index].put(diff,ans);
        return dp[index].get(diff);
    }
    public int longestArithSeqLength(int[] nums)
    {
        int n = nums.length;
        if(n <= 2) return n;


        int ans = 0;

        @SuppressWarnings("unchecked") // Suppressing unchecked warning for the map
        Map<Integer,Integer>[] dp = new Map[n+1];
        for (int i = 0; i < n; i++)
        {
            dp[i] = new HashMap<>();
            for (int j = i+1; j < n; j++)
            {
                ans = Math.max(ans,2 + solve(i,nums[j]-nums[i], nums, dp));
            }
        }

        return ans;
    }
}