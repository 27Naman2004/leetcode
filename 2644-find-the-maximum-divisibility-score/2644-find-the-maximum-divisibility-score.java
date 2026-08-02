class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int max = 0;

        int n = divisors.length;
        int m = nums.length;

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int countDiv = 0;
            for(int j=0;j<m;j++){
                if(nums[j]%divisors[i] == 0) countDiv++;
            }
            if(countDiv > max){
                max = countDiv;
                ans = divisors[i];
            }
            if(countDiv == max){
                ans = Math.min(divisors[i], ans);
            }
        }

        return ans;
    }
}