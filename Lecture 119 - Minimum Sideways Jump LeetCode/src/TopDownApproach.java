import java.util.Arrays;

class TopDownApproach
{
    private int solve(int[] obstacles, int currLane, int currPos, int[][] dp)
    {
        //base case
        int n = obstacles.length-1;
        if(currPos == n) return 0;
        if(dp[currLane][currPos] != -1) return dp[currLane][currPos];

        if(obstacles[currPos + 1] != currLane)
        {
            return solve(obstacles, currLane, currPos+1, dp);
        }
        else
        {
            //sideways jump
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++)
            {
                if(currLane != i && obstacles[currPos] != i)
                    ans = Math.min(ans, 1 + solve(obstacles, i, currPos, dp));
            }
            dp[currLane][currPos] = ans;
            return dp[currLane][currPos];
        }
    }
    public int minSideJumps(int[] obstacles)
    {
        int[][] dp = new int[4][obstacles.length];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(obstacles, 2 , 0, dp);
    }
}