class NumArray {

    int [] SegTree;
    int nums[];
    int n = 0;

    public void build(int nums[], int left, int right, int node){
        if(left == right){
            SegTree[node] = nums[left];
            return;
        }

        int mid = (left + right)/2;

        build(nums, left, mid,2*node+1);
        build(nums, mid+1, right, 2*node+2);

        SegTree[node] = SegTree[2*node+1] + SegTree[2*node+2];
    }

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        if (n > 0) {
            SegTree = new int[4 * n];
            build(nums, 0, n - 1, 0);
        }
    }


    public void updateTree(int left, int right, int index, int val, int node){
        if(left == right){
            SegTree[node] = val;
            return;
        }

        int mid = (left+  right)/2;

        if(index <= mid){
            updateTree(left, mid, index, val, 2*node+1);
        }
        else{
            updateTree(mid+1, right, index, val, 2*node+2);
        }

        SegTree[node] = SegTree[2*node+1]+ SegTree[2*node+2];
    }
    
    public void update(int index, int val) {
        updateTree(0, n-1, index, val, 0);
    }
    public int sumQuery(int left, int right, int node, int qleft, int qright){
        if(qleft <= left && right <= qright){
            return SegTree[node];
        }

        if(right < qleft || left > qright){
            return 0;
        }

        int mid = (left + right)/2;
        int sumLeft = sumQuery(left, mid,  2*node+1, qleft, qright);
        int sumRight = sumQuery(mid+1, right,  2*node+2, qleft, qright);

        return sumLeft + sumRight;
    }
    public int sumRange(int left, int right) {
        return sumQuery(0, n-1, 0, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */