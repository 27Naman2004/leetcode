class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Set<Character> set = new HashSet<>();

        int maxLen = 0;
        int left = 0;
    
        for(int i=0; i<n; i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}