public class Trie
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
        int index = word.charAt(0) - 'A';
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

    private boolean searchUtil(TrieNode root, String word)
    {
        //base case
        if(word.isEmpty())
        {
            return root.isTerminal;
        }

        int index = word.charAt(0)- 'A';
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

    public boolean search(String word)
    {
        return searchUtil(root, word);
    }

    private boolean deleteUtil(TrieNode root, String word) {
        // Base case
        if (word.isEmpty()) {
            // If the word is found, mark isTerminal as false
            if (root.isTerminal) {
                root.isTerminal = false;
                return true;
            }
            return true;
        }

        int index = word.charAt(0) - 'A';
        TrieNode child = root.children[index];

        // If the child node is absent, the word is not in the Trie
        if (child == null) {
            return false;
        }

        // Recursive call to delete the next character in the word
        boolean deleted = deleteUtil(child, word.substring(1));

        // If the word was deleted and the current node has no children, remove the link
        if (deleted && noChildren(child)) {
            root.children[index] = null;
        }

        // If the current node has children, do not delete it
        return deleted;
    }


    // Helper method to check if a TrieNode has no children
    private boolean noChildren(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }


    public boolean delete(String word)
    {
        return deleteUtil(root, word);
    }
}
