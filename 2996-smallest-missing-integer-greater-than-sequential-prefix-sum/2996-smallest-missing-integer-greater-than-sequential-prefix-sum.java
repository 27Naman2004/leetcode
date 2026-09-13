class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n);
        int total = nums[0];

        for(int i: nums){
            set.add(i);
        }

        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1] + 1){
                total += nums[i];
            }
            else{
                break;
            }
        }

        while(set.contains(total)){
            total++;
        }
        return total;
    }
}