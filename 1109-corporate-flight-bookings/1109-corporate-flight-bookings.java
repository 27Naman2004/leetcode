class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int diff[] = new int[n+1];
        for(int i[]: bookings){
            int l = i[0]-1;
            int r = i[1];
            int val = i[2];

            diff[l] += val; 
            diff[r] -= val;
        }
        int sum = 0;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            sum += diff[i];
            nums[i] = sum;
        }
        return nums;
    }
}