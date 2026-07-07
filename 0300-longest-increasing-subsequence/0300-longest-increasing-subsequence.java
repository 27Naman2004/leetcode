class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer dp[][] = new Integer[nums.length+1][nums.length+1];

        return solve(0, -1, nums, dp);
    }
    public int solve(int currIndex, int prevIndex, int nums[], Integer[][]dp){
        if(currIndex == nums.length) return 0;
        if(dp[currIndex][prevIndex+1] !=null) return dp[currIndex][prevIndex+1];
        int take = 0;
        int skip = solve(currIndex+1, prevIndex, nums, dp);
        if(prevIndex == -1 || nums[currIndex] > nums[prevIndex]){
            take = 1 + solve(currIndex+1, currIndex, nums, dp);
        }
        return dp[currIndex][prevIndex+1] = Math.max(skip, take);
    }
}