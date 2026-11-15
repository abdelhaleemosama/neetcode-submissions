class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        backtrack(candidates,0,res,new ArrayList<>(),target);
        return res;
    }

    private void backtrack(
        int[] arr, int start, List<List<Integer>> res, List<Integer> curr, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (start < i && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            curr.add(arr[i]);

            backtrack(arr, i + 1,res,curr,target-arr[i] );

            curr.remove(curr.size() -1);
        }
    }
}
