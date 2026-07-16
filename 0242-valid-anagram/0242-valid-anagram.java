class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int []freq = new int[28];

        for(int i=0;i<s.length();i++){
            int schar  = s.charAt(i);
            int tchar = t.charAt(i);
            freq[schar-'a']++;
            freq[tchar-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}