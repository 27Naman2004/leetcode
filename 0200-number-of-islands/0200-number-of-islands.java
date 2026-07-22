class Solution {
    class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();

        int[][] dir = {{0,-1}, {-1, 0}, {1, 0}, {0,1}};
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.offer(new Pair(i, j));

                    while(!q.isEmpty()){
                        Pair curr = q.poll();

                        for(int[]d: dir){
                            int nr = curr.r + d[0];
                            int nc = curr.c + d[1];

                            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.offer(new Pair(nr, nc));
                            }
                        }
                    }
                }
            }
        }
        return count;
        
    }
}