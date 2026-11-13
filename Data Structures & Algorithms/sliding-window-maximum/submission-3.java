class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        leftMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(nums[i], leftMax[i - 1]);
            }

            if ((n - 1 - i) % k == 0) {
                rightMax[n - 1 - i] = nums[n - 1 - i];
            } else {
                rightMax[n - 1 - i] = Math.max(nums[n - 1 - i], rightMax[n - i]);
            }
        }

        for (int i = 0; i < n - k + 1; i++) {
            res[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
        }

        return res;
    }
}
