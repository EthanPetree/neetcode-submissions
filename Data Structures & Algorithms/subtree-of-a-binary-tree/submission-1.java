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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(match(root, subRoot)) return true;

        if(isSubtree(root.left, subRoot)) return true;

        if(isSubtree(root.right, subRoot)) return true;

        return false;
    }

    public boolean match(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            return match(root.left, subRoot.left) && match(root.right, subRoot.right);
        }

        return false;
    }
}
