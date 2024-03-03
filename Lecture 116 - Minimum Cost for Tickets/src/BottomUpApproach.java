import java.util.Arrays;

class BottomUpApproach
{
    private int solve(int n, int[] days, int[] costs)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[n] = 0;


        for(int k = n-1; k >=0 ; k--)
        {
            //1 day pass
            int option1 = costs[0] + dp[k+1];

            //7 day pass
            int i;
            for (i = k; i < n && days[i] < days[k] + 7; i++);
            int option2 = costs[1] + dp[i];


            //30 days pass
            for (i = k; i < n && days[i] < days[k] + 30; i++);
            int option3 = costs[2] + dp[i];


            dp[k] =  Math.min(option1, Math.min(option2,option3));
        }

        return dp[0];
    }
    public int mincostTickets(int[] days, int[] costs)
    {
        return solve(days.length, days, costs);
    }
}