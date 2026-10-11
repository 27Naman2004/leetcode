class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        int left = 0;
        long maxSum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            if(i - left + 1 > k){
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }

            if(i - left + 1 == k && map.size() == k){
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}