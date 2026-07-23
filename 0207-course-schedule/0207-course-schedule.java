class Solution {
    public boolean canFinish(int numCourses, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>(); 
        int ind [] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]i: queries){
            int u = i[0];
            int v = i[1];
            graph.get(v).add(u);
            ind[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(ind[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int i: graph.get(curr)){
                ind[i]--;
                if(ind[i] == 0){
                    q.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}