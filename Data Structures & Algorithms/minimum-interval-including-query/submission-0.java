class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = queries.length;
        int[][] sortedQueries = new int[n][2];

        for (int i = 0; i < n; i++) {
            // map.put(queries[i], i);
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[n];
        int ctr = 0;

        for (int[] query : sortedQueries) {
            while (ctr < intervals.length && intervals[ctr][0] <= query[0]) {
                pq.offer(new int[] {intervals[ctr][1] - intervals[ctr][0] + 1, intervals[ctr][1]});
                ctr++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < query[0]) {
                pq.poll();
            }
            res[query[1]] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return res;
    }
}
