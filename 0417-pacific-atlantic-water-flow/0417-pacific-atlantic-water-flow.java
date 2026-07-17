class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pecificArr = new boolean[n][m];
        boolean[][] atlanticArr = new boolean[n][m];

        for(int i=0;i<n;i++){
            dfs(heights, pecificArr, i, 0);
            dfs(heights, atlanticArr, i, m-1);
        }

        for(int i=0;i<m;i++){
            dfs(heights, pecificArr, 0, i);
            dfs(heights, atlanticArr, n-1, i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pecificArr[i][j] && atlanticArr[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] arr, boolean[][] visit, int r, int c){
        int [][] dir = {{-1,0},{1, 0},{0,-1}, {0,1}};

        if(visit[r][c]) return;

        visit[r][c] = true;

        for(int []d: dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[0].length && !visit[nr][nc] && arr[nr][nc] >= arr[r][c]){ 
                dfs(arr,visit, nr, nc);
            }
        }
    }
}