class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private final TrieNode root = new TrieNode();
    private final List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#') {
            return;
        }

        TrieNode child = node.children[ch - 'a'];

        if (child == null) {
            return;
        }

        if (child.word != null) {
            result.add(child.word);
            child.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, child);
        dfs(board, r - 1, c, child);
        dfs(board, r, c + 1, child);
        dfs(board, r, c - 1, child);

        board[r][c] = ch;
    }
}
