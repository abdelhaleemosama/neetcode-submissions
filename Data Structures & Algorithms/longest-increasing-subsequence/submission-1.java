class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n + 1];
        int size = 0;

        for (int num : nums) {
            int l = 0, r = size;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (tails[mid] >= num) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            tails[l] = num;
            if (l == size)
                size++;
        }

        return size;
    }
}
