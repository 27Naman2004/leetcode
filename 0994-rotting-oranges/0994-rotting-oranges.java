class Solution {
    public int orangesRotting(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int freshOranges = 0;
        int totalTime = 0;

        Queue<int[]> q = new LinkedList<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 1) freshOranges++;
                
                if(arr[i][j] == 2) q.offer(new int[]{i,j});
            }
        }
        
        while(!q.isEmpty() && freshOranges > 0){
            int s =  q.size();
            for(int i=0;i<s;i++){
                int[] j = q.poll();
                int nr = j[0];
                int nc = j[1];
                if(nr-1 >= 0 && arr[nr-1][nc] == 1){
                    arr[nr-1][nc] = 2;
                    freshOranges--;
                    q.offer(new int[]{nr-1, nc});
                }
                if(nr+1 < n && arr[nr+1][nc] == 1){
                    arr[nr+1][nc] = 2;
                    freshOranges--;
                    q.offer(new int[]{nr+1, nc});
                }
                if(nc-1 >=0 && arr[nr][nc-1] == 1){
                    arr[nr][nc-1] = 2;
                    freshOranges--;
                    q.offer(new int[]{nr, nc-1});
                }
                if(nc+1 < m && arr[nr][nc+1] == 1){
                    arr[nr][nc+1] =2;
                    freshOranges--;
                    q.offer(new int[]{nr, nc+1});
                }
            }
            totalTime++;
        }
        return freshOranges == 0 ?  totalTime : -1;
    }
}