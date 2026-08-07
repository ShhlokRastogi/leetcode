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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> ans=new LinkedList<>();
        if(root==null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode curr=q.poll();
                if(i==0){
                    ans.add(curr.val);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
            }
        }
        return ans;
    }
}
