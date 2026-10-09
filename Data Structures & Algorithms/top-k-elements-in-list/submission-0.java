class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : freq.keySet()) {
            int count = freq.get(num);

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }

            buckets[count].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int count = buckets.length - 1; count >= 0 && index < k; count--) {
            if (buckets[count] == null) {
                continue;
            }

            for (int num : buckets[count]) {
                result[index++] = num;

                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}