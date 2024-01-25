class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    int childCount;
    boolean isTerminal;

    public TrieNode(char data)
    {
        this.data = data;
        for (int i = 0; i < 26; i++)
            children[i] = null;

        this.childCount = 0;
        this.isTerminal = false;
    }
}
