class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                arr.add(nums1[i++]);
            }
            else{
                arr.add(nums2[j++]);
            }
        }
        while(j < n) arr.add(nums2[j++]);
        while(i < m) arr.add(nums1[i++]);
        for(int k=0;k<m+n;k++){
            nums1[k] = arr.get(k);
        }

    }
}