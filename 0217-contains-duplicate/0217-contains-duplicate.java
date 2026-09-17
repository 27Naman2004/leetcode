class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(int i: map.keySet()){
            if(map.get(i) > 1){
                return true;
            }
        }
        return false;
    }
}