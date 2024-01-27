class TrieNode
{
    char data;
    TrieNode[] children;
    boolean isTerminal;

    TrieNode(char ch)
    {
        this.data = ch;
        children = new TrieNode[26];

        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }

        isTerminal = false;
    }
}
