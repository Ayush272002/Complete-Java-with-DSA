class Solution
{
    private boolean solve(String str, String pattern)
    {
        boolean[] prev = new boolean[pattern.length()+1];
        boolean[] curr = new boolean[pattern.length()+1];
        prev[0] = true;

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
            prev[j] = flag;
        }

        for(int i = 1; i <= str.length(); i++)
        {
            for(int j = 1; j <= pattern.length(); j++)
            {
                //match
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?')
                    curr[j] = prev[j-1];
                else if(pattern.charAt(j-1) == '*')
                {
                    curr[j] = (prev[j] || curr[j-1]);
                }
                else curr[j] = false;
            }

            System.arraycopy(curr,0,prev,0,curr.length);
        }

        return prev[pattern.length()];
    }
    public boolean isMatch(String s, String p)
    {
        return solve(s,p);
    }
}