class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, subset, res);

        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);

        dfs(nums, i + 1, subset, res);

        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        dfs(nums, i + 1, subset, res);
    }
}