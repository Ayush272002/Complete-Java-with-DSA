import java.util.Arrays;

class BottomUpApproach
{
    private int solve(int[] obstacles)
    {
        int n = obstacles.length-1;
        int[][] dp = new int[4][obstacles.length];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,Integer.MAX_VALUE));

        //base case
        for (int i = 0; i < 4; i++) {
            dp[i][n] = 0;
        }

        for (int currPos = n-1; currPos >= 0 ; currPos--)
        {
            for (int currLane = 1; currLane <= 3; currLane++)
            {
                if(obstacles[currPos + 1] != currLane)
                {
                    dp[currLane][currPos] =  dp[currLane][currPos+1];
                }
                else
                {
                    //sideways jump
                    int ans = Integer.MAX_VALUE;
                    for (int i = 1; i <= 3; i++)
                    {
                        if(currLane != i && obstacles[currPos] != i)
                            ans = Math.min(ans, 1 + dp[i][currPos+1]);
                    }
                    dp[currLane][currPos] = ans;
                }
            }
        }

        return Math.min(dp[2][0], Math.min(1+dp[1][0], 1 + dp[3][0]));
    }
    public int minSideJumps(int[] obstacles)
    {
        return solve(obstacles);
    }
}