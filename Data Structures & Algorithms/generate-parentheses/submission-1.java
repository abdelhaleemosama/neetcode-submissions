class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(n, 0, 0, res, new StringBuilder());

        return res;
    }

    private void backtrack(int n, int open, int close, List<String> res, StringBuilder curr) {
        if (curr.length() == 2 * n) {
            res.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append('(');
            backtrack(n, open + 1, close, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open) {
            curr.append(')');
            backtrack(n, open, close + 1, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
