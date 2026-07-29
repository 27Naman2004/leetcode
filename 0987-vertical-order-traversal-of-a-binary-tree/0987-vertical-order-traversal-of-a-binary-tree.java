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
    class Pair{
        int level, hd;
        TreeNode root;
        Pair(int level, int hd, TreeNode root){
            this.level = level;
            this.hd = hd;
            this.root = root;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0, root));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while(!q.isEmpty()){
            int s = q.size();
            Pair curr = q.poll();

            map.putIfAbsent(curr.hd, new TreeMap<>());
            map.get(curr.hd).putIfAbsent(curr.level, new PriorityQueue<>());
            map.get(curr.hd).get(curr.level).add(curr.root.val);

            if(curr.root.left != null) q.offer(new Pair(curr.level+1,curr.hd-1,curr.root.left));
            if(curr.root.right != null) q.offer(new Pair(curr.level+1,curr.hd+1, curr.root.right));

        }

        for(var i: map.values()){
            List<Integer> temp = new ArrayList<>();
            for(var j: i.values()){
                while(!j.isEmpty()){
                    temp.add(j.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}