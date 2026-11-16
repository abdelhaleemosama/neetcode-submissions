class Solution {
    private List<List<String>> res;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    private char[][] board;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;

        board = new char[n][n];

        res = new ArrayList<>();
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0);

        return res;
    }

    private void backtrack(int index) {
        if (index == n) {
            List<String> sol = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                sol.add(new String(board[i]));
            }

            res.add(sol);
        }

        for (int i = 0; i < n; i++) {
            int d1 = index - i + n - 1;

            int d2 = index + i;
            if (cols[i] || diag1[d1] || diag2[d2]) {
                continue;
            }

            board[index][i] = 'Q';

            cols[i] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(index + 1);
            board[index][i] = '.';

            cols[i] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
