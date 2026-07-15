class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int color[] = new int[n];
        Arrays.fill(color, -1);

        for(int i=0;i<n;i++){
            if(color[i] ==-1){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;

                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int nei : graph[curr]){
                        if(color[nei]==-1){
                            color[nei] = 1 - color[curr];
                            q.offer(nei); 
                        }
                        else if(color[nei] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}