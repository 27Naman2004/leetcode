class NumArray {

    int[] SegTree;
    int [] nums;
    int n = 0;

    public void build(int left, int right, int node){
        if(left == right){
            SegTree[node] = nums[left];
            return;
        }

        int mid = (left + right)/2;

        build(left, mid, 2*node+1);
        build(mid+1, right, 2*node+2);

        SegTree[node] = SegTree[2*node+1] + SegTree[2*node+2];
    }
    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        if (n > 0) { 
            SegTree = new int[4*n];
            build(0, n-1, 0);
        }
    }

    public int QueryRange(int left, int right, int node, int qleft, int qright){
        if(qleft <= left && right <= qright){
            return SegTree[node];
        }

        if(right < qleft || left > qright){
            return 0;
        }

        int mid = (left + right)/2;

        int leftSum = QueryRange(left, mid, 2*node+1, qleft, qright);
        int rightSum = QueryRange(mid+1, right, 2*node+2, qleft, qright);
        return rightSum + leftSum;
    }
    
    public int sumRange(int left, int right) {
        if(n==0) return 0;
        return QueryRange(0, n-1, 0, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */