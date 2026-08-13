class Solution {
    public int totalFruit(int[] arr) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;

        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while(map.size() > 2){
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);

                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            if(i - left + 1> count){
                count = i - left + 1;
            }
        }
        return count;
    }
}