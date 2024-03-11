class SpaceOptimization
{
    private int solve(int d, int f, int t)
    {
        int[] prev = new int[t+1];
        int[] curr = new int[t+1];

        //base cases
        prev[0] = 1;

        for(int dice = 1; dice <= d; dice++)
        {
            for(int target = 1; target <= t; target++)
            {
                int ans= 0;
                for (int faces = 1; faces <= f; faces++)
                {
                    if(target - faces >= 0)
                    {
                        ans += prev[target-faces];
                        ans %= 1000000007;
                    }
                }
                curr[target] = ans;
            }

            System.arraycopy(curr,0,prev,0,t+1);
        }

        return prev[t];
    }
    public int numRollsToTarget(int n, int k, int target)
    {
        return solve(n,k,target);
    }
}