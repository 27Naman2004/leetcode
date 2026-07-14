class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){

        int[] arr = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){

            Stack<Integer> st = new Stack<>();

            for(int j=0;j<nums2.length;j++){
                st.push(nums2[j]);
            }

            int elem = -1;
            while(!st.isEmpty()){
                int currElm = st.pop();
                if(currElm > nums1[i]){
                    elem = currElm;
                }else if(currElm == nums1[i]){
                    break;
                }
            }
            arr[i] = elem;
        }
        return arr;
    }
}