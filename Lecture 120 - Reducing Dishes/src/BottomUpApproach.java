import java.util.Arrays;

public class BottomUpApproach
{
    private int solve(int[] satisfaction)
    {
       int n = satisfaction.length;
       int[][] dp = new int[n+1][n+1];

       //for nth index it should store 0
        for(int index = n-1; index >= 0; index--)
        {
            for(int time = index; time >= 0; time--)
            {
                int include = (satisfaction[index] * (time + 1)) + dp[index+1][time+1];
                int exclude = dp[index+1][time];

                dp[index][time] = Math.max(include,exclude);
            }
        }

        return dp[0][0];
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solve(satisfaction);
    }
}
