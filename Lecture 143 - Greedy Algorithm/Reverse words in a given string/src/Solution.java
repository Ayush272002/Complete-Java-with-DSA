class Solution
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here
        StringBuilder ans= new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for(int i = S.length()-1; i >= 0; i--)
        {
            if(S.charAt(i)=='.')
            {
                temp.reverse();
                ans.append(temp).append('.');
                temp.delete(0,temp.length());
            }
            else
            {
                temp.append(S.charAt(i));
            }
        }
        temp.reverse();
        ans.append(temp);
        return ans.toString();
    }
}