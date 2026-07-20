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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int countRoot = dfs(root, targetSum);
        int countLeft = pathSum(root.left, targetSum);
        int countRight = pathSum(root.right, targetSum);

        return countRoot + countLeft + countRight;
    }

    public int dfs(TreeNode root, long t){
        if(root == null) return 0;

        int maxCount = 0;

        if(root.val == t){
            maxCount++;
        }

        maxCount += dfs(root.left, t - root.val);
        maxCount += dfs(root.right, t - root.val);

        return maxCount;
    }
}