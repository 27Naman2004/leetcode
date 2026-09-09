class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int val = nums.length;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == target){
                int minCal = Math.abs(i - start);
                val = Math.min(minCal,val);
            }
        }
        return val;
        
    }
}