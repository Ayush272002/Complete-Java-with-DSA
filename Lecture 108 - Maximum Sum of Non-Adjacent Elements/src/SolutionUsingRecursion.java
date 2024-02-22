import java.util.ArrayList;
public class SolutionUsingRecursion {
    private static int solve(ArrayList<Integer> nums, int n)
    {
        //base case
        if(n < 0) return 0;
        if(n == 0) return nums.get(0);

        int include = solve(nums,n-2) + nums.get(n);
        int exclude = solve(nums, n-1) + 0;

        return Math.max(include,exclude);
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums)
    {
        // Write your code here.
        int n = nums.size();
        int ans = solve(nums,n-1);
        return ans;
    }
}