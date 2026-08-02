class Solution {
    public boolean stoneGame(int[] nums) {
        int alice = 0;
        int bob = 0;
        int n = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if((i&1)==0){
                alice += Math.max(nums[i], nums[n-i]);
            }
            else{
                bob += Math.max(nums[i], nums[n-i]);
            }
        }
        return alice >= bob;
    }
}