import java.util.Arrays;

class OptimalSolution
{
    private int solve(int[] obstacles)
    {
        int n = obstacles.length-1;
        int[] curr = new int[4];
        int[] next = new int[4];

        Arrays.fill(curr,Integer.MAX_VALUE);
        Arrays.fill(next,Integer.MAX_VALUE);

        //base case
        for (int i = 0; i < 4; i++) {
            next[i] = 0;
        }

        for (int currPos = n-1; currPos >= 0 ; currPos--)
        {
            for (int currLane = 1; currLane <= 3; currLane++)
            {
                if(obstacles[currPos + 1] != currLane)
                {
                    curr[currLane] =  next[currLane];
                }
                else
                {
                    //sideways jump
                    int ans = Integer.MAX_VALUE;
                    for (int i = 1; i <= 3; i++)
                    {
                        if(currLane != i && obstacles[currPos] != i)
                            ans = Math.min(ans, 1 + next[i]);
                    }
                    curr[currLane] = ans;
                }
            }

            System.arraycopy(curr,0,next, 0, 4);
        }

        return Math.min(next[2], Math.min(1+next[1], 1 + next[3]));
    }
    public int minSideJumps(int[] obstacles)
    {
        return solve(obstacles);
    }
}