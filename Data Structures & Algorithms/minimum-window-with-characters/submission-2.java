class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int l = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int[] need = new int[128];
        int have = 0;

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);

            if (need[c] > 0) {
                have++;
            }
            need[c]--;

            while (have == m) {
                if (r - l + 1 < len) {
                    start = l;
                    len = r - l + 1;
                }

                need[s.charAt(l)]++;
                if (need[s.charAt(l)] > 0)
                    have--;
                l++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
