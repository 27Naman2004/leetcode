class Solution {
    public int findTheDistanceValue(int[] arr, int[] nums, int d) {
        int n = arr.length;
        int m = nums.length;

        int count = 0;
        for(int i=0;i<n;i++){
            boolean flag = true;
            for(int j=0;j<m;j++){
                if(Math.abs(arr[i] - nums[j]) <= d){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }
}