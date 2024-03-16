class TopDownApproach
{
    private boolean solve(String str, String pattern, int i, int j, Boolean[][] dp)
    {
        //base case
        if(i == 0 && j == 0) return true;
        if(i > 0 && j == 0) return false;
        if(i == 0 && j > 0)
        {
            for (int k = 1; k <= j; k++)
            {
                if(pattern.charAt(k-1) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != null) return dp[i][j];

        //match
        if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?')
            return dp[i][j] = solve(str, pattern, i-1, j-1, dp);
        else if(pattern.charAt(j-1) == '*')
        {
            return dp[i][j] = (solve(str, pattern, i-1, j, dp) || solve(str, pattern, i, j-1, dp));
        }
        else return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p)
    {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return solve(s,p,s.length(),p.length(), dp);
    }
}