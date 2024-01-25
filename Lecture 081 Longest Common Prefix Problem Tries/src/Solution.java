class Solution {
    public String longestCommonPrefix(String[] strs)
    {
        Trie t = new Trie('\0');

        //insert all strings into trie
        for (int i = 0; i < strs.length; i++) {
            t.insertWord(strs[i]);
        }

        StringBuilder sb = new StringBuilder();

        String first = strs[0];
        t.lcp(first, sb);
        return sb.toString();
    }
}