class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i[]: invocations){
            int a = i[0];
            int b = i[1];

            graph.get(a).add(b);

        }

        Queue<Integer> q = new LinkedList<>();
        boolean [] visit = new boolean[n];
        visit[k] = true;
        q.offer(k);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int i : graph.get(curr)){
                if(!visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }

        for(int i[]: invocations){
            int a = i[0];
            int b = i[1];

            if(!visit[a] && visit[b]){
                List<Integer> arr = new ArrayList<>();
                for(int j=0;j<n;j++){
                    arr.add(j);
                }
                return arr;
            }
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}