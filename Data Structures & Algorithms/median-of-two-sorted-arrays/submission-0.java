class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m;

        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = (m + n + 1) / 2 - i;

            int right1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int left1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];

            int right2 = j == n ? Integer.MAX_VALUE : nums2[j];
            int left2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];

            if (right1 >= left2 && right2 >= left1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                return ((double) Math.min(right1, right2) + Math.max(left1, left2)) / 2;
            }
            if (right2 < left1) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return 0.0;
    }
}
