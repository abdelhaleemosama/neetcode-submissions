class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxR = height[n-1], maxL = height[0];

        int l = 0, r = n-1;
        int total = 0;

        while(l<r){
            if(height[l]< height[r]){
                if(height[l]<maxL){
                total+=(maxL-height[l]);
                l++;
                }
                else{maxL=height[l];l++;}
            }else{
                if(height[r]<maxR){
                    total+=(maxR-height[r]);
                    r--;
                }
                else{ maxR=height[r];r--;}
            }
            
            
        }

        return total;

    }
}
