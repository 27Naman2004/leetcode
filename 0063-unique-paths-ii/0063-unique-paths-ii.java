class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        if(nums[n-1][m-1] == 1 || nums[0][0] == 1) return 0;
        Integer [][] dp = new Integer[n][m];
        return solve(nums, 0, 0, dp);

    }
    public int solve(int [][] arr, int r, int c, Integer[][]dp){
        int n = arr.length;
        int m = arr[0].length;

        if(r >= n || c >= m || arr[r][c] == 1) return 0;

        if(r == n-1 && c==m-1) return 1;

        if(dp[r][c] != null) return dp[r][c];

        int down = solve(arr, r+1,c, dp);
        int right = solve(arr, r,c+1, dp);
        
        int ways = right + down;

        return dp[r][c] =  ways;
    }
}