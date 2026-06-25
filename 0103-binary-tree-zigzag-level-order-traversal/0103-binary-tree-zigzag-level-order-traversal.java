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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // using bfs tech
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return ans;
        q.offer(root);
        int count = 1;
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            if(count%2==0){
                Collections.reverse(temp);
                ans.add(temp);
            }
            else{
                ans.add(temp);
            }
            count++;
        }
        return ans;
    }
}