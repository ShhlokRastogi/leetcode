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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int r=1;
        int l=1;
        if(root.right!=null){
            r=1+maxDepth(root.right);
        }
        if(root.left!=null){
            l=1+maxDepth(root.left);
        }
        if(l>r){
            return l;
        }else{
            return r;
        }

    }
}
