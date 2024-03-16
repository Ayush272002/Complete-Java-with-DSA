class BottomUpApproach
{
    private boolean solve(String str, String pattern)
    {
        boolean[][] dp = new boolean[str.length()+1][pattern.length()+1];
        dp[0][0] = true;

        for(int j = 1; j <= pattern.length(); j++)
        {
            boolean flag = true;
            for (int k = 1; k <= j; k++)
            {
                if(pattern.charAt(k-1) != '*')
                {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for(int i = 1; i <= str.length(); i++)
        {
            for(int j = 1; j <= pattern.length(); j++)
            {
                //match
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(pattern.charAt(j-1) == '*')
                {
                    dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
                }
                else dp[i][j] = false;
            }
        }

        return dp[str.length()][pattern.length()];
    }
    public boolean isMatch(String s, String p)
    {
        return solve(s,p);
    }
}