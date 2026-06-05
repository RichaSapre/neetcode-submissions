class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int prodOfAllBeforeCurrent = 1;
        int prodOfAllAfterCurrent = 1;

        for(int i = 0; i<n; i++){
            res[i]= prodOfAllBeforeCurrent;
            prodOfAllBeforeCurrent *= nums[i];
        }

        for(int i = n-1; i>=0; i--){
            res[i] *= prodOfAllAfterCurrent;
            prodOfAllAfterCurrent *= nums[i];
        }
        return res;
    }
}  
