import java.util.Arrays;

class TopDownApproach
{
    private int solve(int[] satisfaction, int index, int time, int[][] dp)
    {
        //base case
        if(index == satisfaction.length) return 0;
        if(dp[index][time] != -1) return dp[index][time];

        int include = (satisfaction[index] * (time + 1)) + solve(satisfaction, index+1, time +1, dp);
        int exclude = solve(satisfaction, index+1, time, dp);

        dp[index][time] = Math.max(include,exclude);
        return dp[index][time];
    }
    public int maxSatisfaction(int[] satisfaction)
    {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));

        return solve(satisfaction,0,0, dp);
    }
}