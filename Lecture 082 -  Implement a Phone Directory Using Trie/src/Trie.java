import java.util.ArrayList;

class Trie
{
    TrieNode root;

    Trie()
    {
        root = new TrieNode('\0');
    }

    private void insertUtil(TrieNode root, String word)
    {
        //base case
        if(word.isEmpty())
        {
            root.isTerminal = true;
            return;
        }

        //assumption word will be in caps
        int index = word.charAt(0) - 'a';
        TrieNode child;

        //present
        if(root.children[index] != null)
        {
            child = root.children[index];
        }
        else
        {
            //absent
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        //recursion
        insertUtil(child, word.substring(1));
    }

    public void insertWord(String word)
    {
        insertUtil(root,word);
    }

    private void printSuggest(TrieNode curr, ArrayList<String> temp, StringBuilder prefix)
    {
        if(curr.isTerminal)
        {
            temp.add(prefix.toString());
        }

        for(char ch = 'a'; ch<='z'; ch++)
        {
            TrieNode next = curr.children[ch-'a'];

            if(next != null)
            {
                prefix.append(ch);
                printSuggest(next, temp, prefix);

                prefix.deleteCharAt(prefix.length()-1);
            }
        }
    }
    public ArrayList<ArrayList<String>> getSuggestions(String str)
    {
        TrieNode prev = root;
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char lastCh = str.charAt(i);

            prefix.append(lastCh);

            //check for last character
            TrieNode curr = prev.children[lastCh-'a'];

            //if not found
            if(curr == null)
            {
                break;
            }

            //if found
            ArrayList<String> temp = new ArrayList<>();
            printSuggest(curr, temp, prefix);

            output.add(temp);
            prev = curr;
        }

        return output;
    }
}
