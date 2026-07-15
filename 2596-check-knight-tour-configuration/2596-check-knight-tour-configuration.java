class Solution {
    class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        int count = 0;
        if(grid[0][0] != 0) return false;
        Queue<Pair> q = new  LinkedList<>();

        int[][] dir = {
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, 1},
            {-2, -1},
            {-1, 2},
            {1, 2}
        };

        q.offer(new Pair(0, 0));
        
        while(!q.isEmpty()){
            int s = q.size();
            Pair index = q.poll();
            boolean found = false; 
            for(int  i[]: dir){
                int nr = index.r + i[0];
                int nc = index.c + i[1];
                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                if(grid[nr][nc] == count+1){
                    q.offer(new Pair(nr, nc));
                    count++;
                    found = true;
                    break;
                }

            }
            if(!found && count != n*n-1) return false;
        }
        return count == n*n-1;
    }
}