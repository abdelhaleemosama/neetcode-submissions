class Solution {
    public int rob(int[] nums) {
        int p1 = 0, p2 = 0;
        for(int n:nums){
            int curr = Math.max(p2 + n, p1);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
}