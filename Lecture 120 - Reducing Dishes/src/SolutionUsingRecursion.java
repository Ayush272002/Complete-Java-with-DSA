import java.util.Arrays;

class SolutionUsingRecursion
{
    private int solve(int[] satisfaction, int index, int time)
    {
        //base case
        if(index == satisfaction.length) return 0;

        int include = (satisfaction[index] * (time + 1)) + solve(satisfaction, index+1, time +1);
        int exclude = solve(satisfaction, index+1, time);

        return Math.max(include,exclude);
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solve(satisfaction,0,0);
    }
}