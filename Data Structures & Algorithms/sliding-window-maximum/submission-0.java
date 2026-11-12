class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int l = 0;
        for (int r = 0; r < n; r++) {
            pq.offer(new int[] {nums[r],r});
            if (r >= k - 1) {
                while (pq.peek()[1] <= r - k) {
                    pq.poll();
                }
                res[l++] = pq.peek()[0];
            }
        }

        return res;
    }
}
