import java.util.Arrays;

public class OptimisedSolution
{
    private int solve(int[] satisfaction)
    {
        int n = satisfaction.length;
        int[] curr = new int[n+1];
        int[] next = new int[n+1];

        //for nth index it should store 0
        for(int index = n-1; index >= 0; index--)
        {
            for(int time = index; time >= 0; time--)
            {
                int include = (satisfaction[index] * (time + 1)) + next[time+1];
                int exclude = next[time];

                curr[time] = Math.max(include,exclude);
            }

            System.arraycopy(curr,0,next,0,n+1);
        }

        return next[0];
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solve(satisfaction);
    }
}
