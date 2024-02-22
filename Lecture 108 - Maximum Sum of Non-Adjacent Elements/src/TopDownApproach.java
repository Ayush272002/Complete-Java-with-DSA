import java.util.ArrayList;
import java.util.Arrays;
public class TopDownApproach
{
    private static int solve(ArrayList<Integer> nums, int n, int[] dp)
    {
        //base case
        if(n < 0) return 0;
        if(n == 0) return nums.get(0);
        if(dp[n] != -1) return dp[n];

        int include = solve(nums,n-2, dp) + nums.get(n);
        int exclude = solve(nums, n-1, dp) + 0;


        dp[n] = Math.max(include,exclude);
        return Math.max(include,exclude);
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums)
    {
        // Write your code here.
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = solve(nums,n-1,dp);
        return ans;
    }
}

/*
TC - O(n)
SC - O(n) + O(n)
 */