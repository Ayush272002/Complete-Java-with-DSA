class SolutionUsingRecursion
{
    private int solve(String a, String b, int i, int j)
    {
        if(i == a.length()) return b.length() - j;
        if(j == b.length()) return a.length() - i;

        int ans = 0;
        if(a.charAt(i) == b.charAt(j))
        {
            return solve(a, b, i+1, j+1);
        }
        else
        {
            int insert = 1 + solve(a, b, i, j+1);
            int delete = 1 + solve(a, b, i+1, j);
            int replace = 1 + solve(a, b, i+1, j+1);

            ans = Math.min(insert,Math.min(delete,replace));
        }

        return ans;
    }
    public int minDistance(String word1, String word2)
    {
        return solve(word1,word2,0,0);
    }
}