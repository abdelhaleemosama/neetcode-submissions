class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];

                if (digit == '.')
                    continue;

                int boxIndex = ((i / 3) * 3) + (j / 3);

                if (rows[i].contains(digit) || cols[j].contains(digit)
                    || boxes[boxIndex].contains(digit)) {
                    return false;
                }

                rows[i].add(digit);
                cols[j].add(digit);
                boxes[boxIndex].add(digit);
            }
        }

        return true;
    }
}
