class OptimisedSol
{
    private int solve(String a, String b)
    {
        int[][] dp = new int[a.length()+1][b.length()+1];

        int[] curr = new int[b.length()+1];
        int[] next = new int[b.length()+1];

        for(int j = 0; j < b.length(); j++)
        {
            next[j] = b.length() - j;
        }

        for (int i = 0; i < a.length(); i++)
        {
            curr[b.length()] = a.length() - i;
        }

        for(int i = a.length()-1; i >= 0; i--)
        {
            for(int j = b.length()-1; j >= 0; j--)
            {
                curr[b.length()] = a.length() - i; // imp part
                int ans = 0;
                if(a.charAt(i) == b.charAt(j))
                {
                    ans = next[j+1];
                }
                else
                {
                    int insert = 1 + curr[j+1];
                    int delete = 1 + next[j];
                    int replace = 1 + next[j+1];

                    ans = Math.min(insert,Math.min(delete,replace));
                }

                curr[j] = ans;
            }

            System.arraycopy(curr,0,next,0,curr.length);
        }

        return next[0];
    }
    public int minDistance(String word1, String word2)
    {
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();
        return solve(word1,word2);
    }
}