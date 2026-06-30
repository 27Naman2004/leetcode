class Solution {
    public int numDecodings(String s) {
        // tabulation
        if(s.charAt(0) == '0' || s.length() == 0 || s ==null) return 0;
        int [] dp = new int[s.length()+1];
        
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=s.length();i++){
            char single = s.charAt(i-1);
            if(single != '0'){
                dp[i] += dp[i-1];
            }

            int digit = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
            if(digit >= 10 && digit <= 26){
                dp[i] += dp[i-2];
            }

        }
        return dp[s.length()];
    }


    // Memo, Using DP
    /*
    public int helper(int i, String s, int[]dp){
        if(s.length()==i){
            return 1;
        }

        if(s.charAt(i)=='0') return 0;

        if(dp[i] != -1) return dp[i];

        int ways = helper(i+1, s, dp);

        if(i+1 < s.length()){
            int digit = (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
            if(digit >= 10 && digit <= 26){
                ways += helper(i+2, s, dp);
            }
        }
        return dp[i] = ways;
    }
    */

    // From Rec. Done
    /*
    public int solve(int i, String s){
        if(s.length()==i) return 1;

        if(s.charAt(i)=='0') return 0;
        int ways = solve(i+1,s);

        if(i+1 < s.length()){
            int digit = (s.charAt(i)-'0') * 10 + (s.charAt(i+1)-'0');
            if(digit >= 10 && digit <= 26){
                ways += solve(i+2, s);
            }
        }
        return ways;
    }
    */


}