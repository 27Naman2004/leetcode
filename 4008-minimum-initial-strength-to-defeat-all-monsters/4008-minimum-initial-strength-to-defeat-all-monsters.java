class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long [] diff = new long[n+1];
        
        for(int i[]: boosts){
            int l = i[0];
            int r = i[1];
            int val = i[2];

            diff[l] += val;
            diff[r+1] -= val;
        }

        long [] bonus = new long[n];
        long valInBonus = 0;

        for(int i=0;i<n;i++){
            valInBonus += diff[i];
            bonus[i] = valInBonus;
        }

        long left = 0;
        long right = 1000000000000005L;
        long ans = right;
        
        while(left <= right){
            long mid = left + (right - left)/2;

            if(canBe(mid, bonus, monsters)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
    public boolean canBe(long initialStrength, long[] bonus, int[] monster){
        long CurrStrength = initialStrength;

        for(int i=0;i<monster.length;i++){
            if(CurrStrength +  bonus[i] < monster[i]) return false;

            CurrStrength -= monster[i];

            if(CurrStrength < 0){
                CurrStrength = 0;
            }
        }
        return true;
    }
}