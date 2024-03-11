class SolutionUsingRecursion
{
    private int solve(int dice, int faces, int target)
    {
        //base case
        if(target < 0) return 0;
        if(dice == 0 && target != 0) return 0;
        if(target ==0 && dice != 0) return 0;
        if(dice == 0 && target == 0) return 1;


        int ans= 0;
        for (int i = 1; i <= faces; i++) {
            ans += solve(dice-1, faces, target-i);
        }

        return ans;
    }
    public int numRollsToTarget(int n, int k, int target)
    {
        return solve(n, k, target) % 1000000007;
    }
}