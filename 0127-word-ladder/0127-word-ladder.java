class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        boolean visit[] = new boolean[wordList.size()];

        int count = 1;
        q.offer(beginWord);
        while(!q.isEmpty()){
            int s = q.size();
            
            for(int i=0;i<s;i++){
                String curr = q.poll();
                if(curr.equals(endWord)) return count;

                for(int j=0;j<wordList.size();j++){
                    if(!visit[j] && helper(wordList.get(j), curr)){
                        q.offer(wordList.get(j));
                        visit[j] = true;
                    }
                }
            }
            count++;
        }
        return 0;
    }
    public boolean helper(String s, String b){
        int diff = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}