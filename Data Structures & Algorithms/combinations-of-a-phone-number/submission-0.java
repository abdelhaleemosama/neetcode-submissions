class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }
        String[] digitMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(digits, 0, new StringBuilder(), res, digitMap);

        return res;
    }

    private void backtrack(
        String digits, int index, StringBuilder curr, List<String> res, String[] map) {
        if (digits.length() == index) {
            res.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            curr.append(c);
            backtrack(digits, index + 1, curr, res, map);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
