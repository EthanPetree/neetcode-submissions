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
    private int maxHeightDiff = 0;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return maxHeightDiff <= 1;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        if(left < 0) return -1;
        int right = dfs(root.right);
        if(right < 0) return -1;

        if(Math.abs(left - right) > 1){
            maxHeightDiff = Math.abs(left - right);
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
