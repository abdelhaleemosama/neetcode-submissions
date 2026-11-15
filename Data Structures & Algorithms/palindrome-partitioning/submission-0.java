class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(s, 0, curr, res);

        return res;
    }

    private void backtrack(String s, int index, List<String> curr, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));

                backtrack(s, i + 1, curr, res);

                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
