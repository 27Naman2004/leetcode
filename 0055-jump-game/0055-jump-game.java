class Solution {
    public boolean canJump(int[] nums) {
        Boolean [] dp = new Boolean[nums.length];

        return greedy(nums);
    }

    // Greedy method
    public static Boolean greedy(int nums[]){
        int maxIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(i > maxIndex) return false;

            maxIndex = Math.max(maxIndex, i + nums[i]);

            if(maxIndex >= nums.length -1) return true;
        }
        return false;
    }
    // memo method
    public static Boolean memorisation(Boolean[] dp, int[] nums, int idx){
        if(idx == nums.length-1) return dp[idx] =  true;
        if(dp[idx]!= null) return dp[idx];
        for(int j=1;j<=nums[idx];j++){
            boolean ans = false;
            if(idx + j < nums.length){
                ans = memorisation(dp, nums, idx+j);
            }
            if(ans) return true;
        }
        dp[idx] = false;
        return false;
    }
    // recursion method
    public static boolean dfs(int [] nums, int idx){
        if(idx == nums.length-1) return true;
        for(int i=1;i<=nums[idx];i++){
            boolean ans = false; 
            if(idx +i  < nums.length){
                ans = dfs(nums, idx+i);
            }
            if(ans) return true;
        }
        return false;
    }
}