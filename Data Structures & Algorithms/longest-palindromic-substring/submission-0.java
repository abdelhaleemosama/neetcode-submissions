class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n];

        int maxLength = 1;
        int start = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = j - i <= 2 || dp[j - 1];
                    if (dp[j] && (j - i + 1 > maxLength)) {
                        start = i;
                        maxLength = j - i + 1;
                    }
                } else {
                    dp[j] = false;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
