class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int maxLen = 0;
        int left = 0;   
        int right = 0;
        int n = s.length();
        for(int i=0;i<n;){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                maxLen = Math.max(maxLen, i - left + 1);
                i++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}