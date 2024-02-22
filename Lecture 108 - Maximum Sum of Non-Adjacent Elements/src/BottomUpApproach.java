import java.util.ArrayList;
import java.util.Arrays;

public class BottomUpApproach {
    private static int solve(ArrayList<Integer> nums, int n) {
        // Base case
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        // Base case
        dp[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            int include = (i >= 2 ? dp[i - 2] : 0) + nums.get(i);
            int exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0; // Handle edge case where input list is empty

        return solve(nums, n);
    }
}
/*
TC - O(n)
SC - O(n)
 */