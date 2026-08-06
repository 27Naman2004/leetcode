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
        int height;
        int level;
        TreeNode root;
        Pair(TreeNode root, int level, int height){
            this.root = root;
            this.level = level;
            this.height = height;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new  ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            int s = q.size();

            
            for(int i=0;i<s;i++){
                Pair curr = q.poll();

                int level = curr.level;
                int height = curr.height;
                TreeNode node = curr.root;

                map.putIfAbsent(level, new TreeMap<>());
                map.get(level).putIfAbsent(height, new PriorityQueue<>());
                map.get(level).get(height).add(node.val);

                if(node.left != null){
                    q.offer(new Pair(node.left, level-1, height+1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, level+1, height+1));
                }
            }
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