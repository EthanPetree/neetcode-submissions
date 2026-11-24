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
    private int counter;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return Integer.MAX_VALUE;

        int left = kthSmallest(root.left, k);
        if(counter == k) return left;
        counter++;
        if(counter == k) return root.val;
        int right = kthSmallest(root.right, k);
        if(counter == k) return right;

        return Integer.MAX_VALUE;
    }
}
