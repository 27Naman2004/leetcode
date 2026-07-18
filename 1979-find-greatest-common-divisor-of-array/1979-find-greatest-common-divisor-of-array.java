class Solution {
    int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x%y);
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            min=Math.min(i, min);
            max=Math.max(i, max);
        }
        return gcd(min, max);
    }
}