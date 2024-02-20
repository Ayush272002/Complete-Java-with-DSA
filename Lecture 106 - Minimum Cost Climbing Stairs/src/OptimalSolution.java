public class OptimalSolution {
    private int solve(int[] cost, int n)
    {
        int prev1 = cost[0];
        int prev2 = cost[1];

        for(int i = 2; i < n; i++)
        {
            int cur = cost[i] + Math.min(prev1 , prev2);
            prev1 = prev2;
            prev2 = cur;
        }

        return Math.min(prev1,prev2);
    }
    public int minCostClimbingStairs(int[] cost)
    {
        return solve(cost,cost.length);
    }
}

/*
SC - O(1)
TC - O(N)
 */
