package leetcode.task98;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateChildren(root);
    }

    private boolean validateChildren(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!validateChildren(node.left) || !validateChildren(node.right)) {
            return false;
        }
        if (node.left != null && node.left.val >= node.val) {
            return false;
        }
        if (node.right != null && node.right.val <= node.val) {
            return false;
        }

        return true;
    }
}
