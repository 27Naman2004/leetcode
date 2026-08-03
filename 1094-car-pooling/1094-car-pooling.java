    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            
            int[] diff = new int[10001];
            for(int i[]: trips){
                int val = i[0];
                int l = i[1];
                int r = i[2];

                diff[l] += val;
                diff[r] -= val;
            }
            int [] nums = new int[diff.length];
            int sum = 0;

            for(int i=0;i<diff.length;i++){
                sum += diff[i];
                nums[i] = sum;
            }
            for(int i: nums){
                if(i > capacity) return false;
            }
            return true;
        }
    }