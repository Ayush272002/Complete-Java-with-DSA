import java.util.ArrayList;

public class OptimisedSolution {
    private static int solve(ArrayList<Integer> nums, int n) {
        // Base case
        int prev2  = 0;
        int prev1 = nums.get(0);

        for (int i = 1; i < n; i++) {
            int include = (i >= 2 ? prev2 : 0) + nums.get(i);
            int exclude = prev1;
            int ans = Math.max(include, exclude);

            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0; // Handle edge case where input list is empty

        return solve(nums, n);
    }
}
/*
TC - O(n)
SC - O(1)
 */