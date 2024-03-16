class Solution
{
    private int solve(String text1, String text2)
    {
        int n = text1.length();
        int m = text2.length();

        int[] curr = new int[Math.max(n,m)+1];
        int[] next = new int[Math.max(n,m)+1];

        for (int i = n-1; i >= 0; i--)
        {
            for(int j = m-1; j >= 0; j--)
            {
                int ans = 0;
                if(text1.charAt(i) == text2.charAt(j))
                {
                    ans = 1 + next[j+1];
                }
                else
                {
                    ans = Math.max(next[j], curr[j+1]);
                }

                curr[j] = ans;
            }

            System.arraycopy(curr,0,next,0,curr.length);
        }

        return next[0];
    }
    public int longestPalindromeSubseq(String s)
    {
        StringBuilder rev = new StringBuilder(s).reverse();
        return solve(s,rev.toString());
    }
}

//solution based on longest common subsequence Q1143