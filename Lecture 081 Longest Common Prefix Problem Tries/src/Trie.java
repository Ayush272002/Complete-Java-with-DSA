class Trie
{
    TrieNode root;

    Trie(char ch)
    {
        root = new TrieNode(ch);
    }

    private void insertUtil(TrieNode root, String word)
    {
        if(word.isEmpty())
        {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(0)-'a';
        TrieNode child;

        if(root.children[index] != null)
        {
            child = root.children[index];
        }
        else
        {
            child = new TrieNode(word.charAt(0));
            root.childCount++;
            root.children[index] = child;
        }

        insertUtil(child, word.substring(1));
    }

    public void insertWord(String word)
    {
        insertUtil(root, word);
    }

    public void lcp(String str, StringBuilder sb)
    {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(root.childCount == 1 && !root.isTerminal)
            {
                sb.append(ch);
                int index = ch -'a';
                root = root.children[index];
            }
            else break;

            if(root.isTerminal) break;
        }
    }
}
