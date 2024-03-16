class SolutionUsingRecursion
{
    private int solve(String text1, String text2, int i, int j)
    {
        //base case
        if(i == text1.length() || j == text2.length()) return 0;

        int ans = 0;
        if(text1.charAt(i) == text2.charAt(j))
        {
            ans = 1 + solve(text1, text2, i+1, j+1);
        }
        else
        {
            ans = Math.max(solve(text1, text2, i+1, j), solve(text1, text2, i, j+1));
        }

        return ans;
    }
    public int longestCommonSubsequence(String text1, String text2)
    {
        return solve(text1,text2,0,0);
    }
}