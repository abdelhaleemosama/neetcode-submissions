class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums){
            if(!seen.add(n)) return true;

        }
        return false;
    }
}