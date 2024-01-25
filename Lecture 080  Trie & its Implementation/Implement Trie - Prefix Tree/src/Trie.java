class Trie {
    TrieNode root;

    public Trie() {
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

    public void insert(String word) {
        insertUtil(root,word);
    }

    private boolean searchUtil(TrieNode root, String word)
    {
        //base case
        if(word.isEmpty())
        {
            return root.isTerminal;
        }

        int index = word.charAt(0)- 'a';
        TrieNode child;

        //present
        if(root.children[index] != null)
        {
            child = root.children[index];
        }
        else
        {
            //absent
            return false;
        }

        //recursion
        return searchUtil(child, word.substring(1));
    }

    public boolean search(String word) {
        return searchUtil(root, word);
    }

    private boolean startsWithUtil(TrieNode root, String word)
    {
        //base case
        if(word.isEmpty())
        {
            return true;
        }

        int index = word.charAt(0)- 'a';
        TrieNode child;

        //present
        if(root.children[index] != null)
        {
            child = root.children[index];
        }
        else
        {
            //absent
            return false;
        }

        //recursion
        return startsWithUtil(child, word.substring(1));
    }

    public boolean startsWith(String prefix) {
        return startsWithUtil(root, prefix);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */