class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});

        int [][] dist = {{-1, 0},  {0, -1}, {1, 0}, {0, 1}, 
                        {-1, -1}, {1, 1},  {-1, 1}, {1, -1}};

        grid[0][0] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = curr[2];
            
            if(r == n-1 && c == n-1) return dis;

            for(int i[]: dist){
                int nr = r + i[0];
                int nc = c + i[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0){
                    q.offer(new int[]{nr, nc, dis+1});
                    grid[nr][nc] =  1;
                }
            }
        }
        return -1;
    }
}