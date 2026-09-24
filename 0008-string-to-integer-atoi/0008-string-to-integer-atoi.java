class Solution {
    public int myAtoi(String s) {

        if(s.isEmpty() || s == null) return 0;
        int n  = s.length();
        int sign = 1;
        int i = 0;
        long num = 0;

        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        if( i== n) return 0;
        
        if(s.charAt(i) == '+'){
            sign *= 1;
            i++;
        }
        else if(s.charAt(i)== '-'){
            sign *= -1;
            i++;
        }

        while(i < n && Character.isDigit(s.charAt(i))){
            int val = s.charAt(i) - '0';
            num  = num * 10 + val;

            if(num * sign <= Integer.MIN_VALUE) return  Integer.MIN_VALUE;
            if(num * sign >= Integer.MAX_VALUE) return  Integer.MAX_VALUE;

            i++;
        }

        return (int)(num * sign);
    }
}