class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // Descending end
            }
            return Integer.compare(a[0], b[0]); // Ascending start
        });
        
        int count  = 0;
        int maxEnd = 0;

        for(int i[]: intervals){
            int end = i[1];
            if(end > maxEnd){
                maxEnd = end;
                count++;
            }
        }
        return count;
    }
}