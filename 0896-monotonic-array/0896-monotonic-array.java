class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean isInc =true;
        boolean isDec =true;
        for(int i=1;i<n;i++){
            if(nums[i] < nums[i-1] ) isInc = false;
            if(nums[i] > nums[i-1] ) isDec = false;

            if(!isInc && !isDec) return false;
        }
        return isInc || isDec;
    }
}