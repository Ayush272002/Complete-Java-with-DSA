class SolutionUsingRecursion
{
    private boolean solve(String str, String pattern, int i, int j)
    {
        //base case
        if(i < 0 && j < 0) return true;
        if(i >= 0 && j < 0) return false;
        if(i < 0 && j >= 0)
        {
            for (int k = 0; k <= j; k++) {
                if(pattern.charAt(k) != '*') return false;
            }
            return true;
        }

        //match
        if(str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')
            return solve(str, pattern, i-1, j-1);
        else if(pattern.charAt(j) == '*')
        {
            return (solve(str, pattern, i-1, j) || solve(str, pattern, i, j-1));
        }
        else return false;
    }
    public boolean isMatch(String s, String p)
    {
        return solve(s,p,s.length()-1,p.length()-1);
    }
}