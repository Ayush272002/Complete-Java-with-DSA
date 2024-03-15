import java.util.Arrays;

class TopDownApproach
{
    private int solve(int start, int end, int[][] dp)
    {
        //base case
        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];

        int maxi = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            maxi = Math.min(maxi, i + Math.max(solve(start,i-1, dp), solve(i+1,end, dp)));
        }

        return dp[start][end] = maxi;
    }
    public int getMoneyAmount(int n)
    {
        int[][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(1,n, dp);
    }
}