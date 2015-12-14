/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null)return true;
        return isMirror(root.left,root.right);
    } 
        public boolean isMirror(TreeNode left1,TreeNode right1){
            if(left1==null && right1==null)return true;
            if(left1==null && right1!=null)return false;
            if(left1!=null && right1==null)return false;
            if(left1.val!=right1.val)return false;
            return isMirror(left1.left,right1.right) && isMirror(left1.right,right1.left);
        }
        
        
    
}