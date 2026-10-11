class Solution {
    public int totalFruit(int[] nums) {
        int n = nums.length;

        int left = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            while(map.size() > 2){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }

            if(i - left + 1 > count){
                count = i - left + 1;
            }
        }
        return count;
    }
}