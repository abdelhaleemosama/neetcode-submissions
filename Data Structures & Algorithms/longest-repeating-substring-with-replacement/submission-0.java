class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l =0, max = 0, result = 0;
        for(int r = 0; r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            max = Math.max(max, freq[s.charAt(r) - 'A']);
            while(r-l+1 > max+k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            result = Math.max(result, r-l+1);
        }
        return result;
    }
}
