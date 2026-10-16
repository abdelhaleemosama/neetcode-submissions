class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int res = nums[0];

        for(int i = 1;i<nums.length;i++){
            if(nums[i] < 0){
                int tmp = minProd;
                minProd = maxProd;
                maxProd = tmp;
            }

            minProd = Math.min(nums[i],minProd*nums[i]);
            maxProd = Math.max(nums[i],maxProd*nums[i]);

            res = Math.max(res,maxProd);
        }

        return res;
    }
}
