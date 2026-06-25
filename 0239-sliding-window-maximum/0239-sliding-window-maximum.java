class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        int idx = 0;
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offer(i);

            if(i >= k-1){
                res[idx++] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}