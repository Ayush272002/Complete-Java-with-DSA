class SolutionUsingRecursion
{
    private int solve(int[] obstacles, int currLane, int currPos)
    {
        //base case
        int n = obstacles.length-1;
        if(currPos == n) return 0;

        if(obstacles[currPos + 1] != currLane)
        {
            return solve(obstacles, currLane, currPos+1);
        }
        else
        {
            //sideways jump
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++)
            {
                if(currLane != i && obstacles[currPos] != i)
                    ans = Math.min(ans, 1 + solve(obstacles, i, currPos));
            }
            return ans;
        }
    }
    public int minSideJumps(int[] obstacles)
    {
        return solve(obstacles, 2/*currLane*/ , 0/*position*/);
    }
}