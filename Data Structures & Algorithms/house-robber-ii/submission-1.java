class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        return Math.max(
            robRange(nums,0,nums.length-1), robRange(nums,1,nums.length)
        );
    }
    private int robRange(int[] nums, int st, int end) {
        if(end - st == 1) return nums[st];
        int prev1 = 0, prev2 = 0;
        for (int i = st; i < end; i++) {
            int curr = Math.max(prev1,prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
