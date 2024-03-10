import java.util.Arrays;

class OptimalSolution
{
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int ans = 0;
        int maxTotalSatisfaction = 0;
        int numDishes = satisfaction.length;

        for (int i = numDishes - 1; i >= 0 && satisfaction[i] > -ans; i--) {
            ans += satisfaction[i];
            maxTotalSatisfaction += ans;
        }

        return maxTotalSatisfaction;
    }
}