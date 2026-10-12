class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        int left = 0;

        for(int i=0; i<n; i++){
            sum += nums[i];

            while(sum >= target){
                sum -= nums[left];
                count = Math.min(i-left+1, count);
                left++;
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}