class BottomUpApproach
{
    private int solve(String a, String b)
    {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int j = 0; j < b.length(); j++)
        {
            dp[a.length()][j] = b.length() - j;
        }

        for (int i = 0; i < a.length(); i++)
        {
            dp[i][b.length()] = a.length() - i;
        }

        for(int i = a.length()-1; i >= 0; i--)
        {
            for(int j = b.length()-1; j >= 0; j--)
            {
                int ans = 0;
                if(a.charAt(i) == b.charAt(j))
                {
                    ans = dp[i+1][j+1];
                }
                else
                {
                    int insert = 1 + dp[i][j+1];
                    int delete = 1 + dp[i+1][j];
                    int replace = 1 + dp[i+1][j+1];

                    ans = Math.min(insert,Math.min(delete,replace));
                }

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }
    public int minDistance(String word1, String word2)
    {
        return solve(word1,word2);
    }
}