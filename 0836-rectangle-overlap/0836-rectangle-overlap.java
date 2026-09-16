class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int n =  rec1.length;
        int m =  rec2.length;

        if(n < 4 || m < 4) return false;

        return rec1[0] < rec2[2] && rec2[0] < rec1[2] &&
               rec1[1] < rec2[3] && rec2[1] < rec1[3];

    }
}