import java.util.ArrayList;

public class Solution
{
    static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr)
    {
        // code here
        
        Trie t = new Trie();
        
        //insert all contactList in trie
        for (int i = 0; i < contactList.size(); i++) {
            String str = contactList.get(i);
            t.insertWord(str);
        }

        //return ans
        return t.getSuggestions(queryStr);
    }
}