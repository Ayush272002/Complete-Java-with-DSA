class BottomUpApproach
{
    private int solve(String text1, String text2)
    {
       int n = text1.length();
       int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = n-1; i >= 0; i--)
        {
            for(int j = m-1; j >= 0; j--)
            {
                int ans = 0;
                if(text1.charAt(i) == text2.charAt(j))
                {
                    ans = 1 + dp[i+1][j+1];
                }
                else
                {
                    ans = Math.max(dp[i+1][j], dp[i][j+1]);
                }

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }
    public int longestCommonSubsequence(String text1, String text2)
    {
        return solve(text1,text2);
    }
}