class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c != '.') {
            int childIndex = c - 'a';
            TrieNode child = node.children[childIndex];

            if (child == null) {
                return false;
            }

            return dfs(child, word, index + 1);
        }

        for (TrieNode child : node.children) {
            if (child != null && dfs(child, word, index + 1)) {
                return true;
            }
        }

        return false;
    }
}
