class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zero = 0;
        int left = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                zero++;
            }
            if(zero > k){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}