class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty())
            return "";

        int[] need = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int l = 0, r = 0;
        int minL = 0, minLength = Integer.MAX_VALUE;
        int have = 0, required = t.length();
        int n = s.length();

        while (r < n) {
            char c = s.charAt(r);
            if (need[c] > 0) {
                have++;
            }

            need[c]--;
            r++;

            while (have == required) {
                if (r - l < minLength) {
                    minLength = r - l;
                    minL = l;
                }
                need[s.charAt(l)]++;
                if (need[s.charAt(l)] > 0)
                    have--;
                l++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minL, minLength + minL);
    }
}
