import java.util.Arrays;

class TopDownApproach
{
    private int solve(String a, String b, int i, int j, int[][] dp)
    {
        if(i == a.length()) return b.length() - j;
        if(j == b.length()) return a.length() - i;
        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if(a.charAt(i) == b.charAt(j))
        {
            return solve(a, b, i+1, j+1, dp);
        }
        else
        {
            int insert = 1 + solve(a, b, i, j+1, dp);
            int delete = 1 + solve(a, b, i+1, j, dp);
            int replace = 1 + solve(a, b, i+1, j+1, dp);

            ans = Math.min(insert,Math.min(delete,replace));
        }

        return dp[i][j] = ans;
    }
    public int minDistance(String word1, String word2)
    {
        int[][] dp = new int[word1.length()][word2.length()];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));
        return solve(word1,word2,0,0, dp);
    }
}