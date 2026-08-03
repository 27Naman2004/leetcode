class Solution {
    public int countValidPrefixes(String s) {
        int n = s.length();

        int ans = 0;
        int count1 = 0;
        int count0 = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1') count1++;
            if(s.charAt(i) == '0') count0++;

            if(Math.abs(count0 - count1) <= 1){
                ans++;
            }
        }
        return ans;
    }
}