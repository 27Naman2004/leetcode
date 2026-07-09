class Solution {
    class DSU{
        int parent[];
        DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int i = find(x);
            int j = find(y);

            if(i!=j){
                parent[i] = j;
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu = new DSU(n);

        boolean[] arr = new boolean[queries.length];
        int j = 0;
        for(int i=0;i<n-1;i++){
            if(Math.abs(nums[i] - nums[i+1]) <= maxDiff){
                dsu.union(i, i+1);
            }
        }
        for(int i[]: queries){
            int x = i[0];
            int y = i[1];

            
            arr[j++] = (dsu.find(x) == dsu.find(y)); 
            
        }
        return arr;
    }
}