/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<List<Integer>> level = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            level.add(temp);
        }   

        for(List<Integer> i: level){
            double sum = 0;
            for(int j=0;j<i.size();j++){
                sum+=i.get(j);
            }
            double avg = sum / (double)i.size();
            ans.add(avg);
        }
        return ans;
    }
}