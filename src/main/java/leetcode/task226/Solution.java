package leetcode.task226;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        invertChildren(root);

        return root;
    }

    private void invertChildren(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode oldLeft = node.left;
        node.left = node.right;
        node.right = oldLeft;
        invertChildren(node.left);
        invertChildren(node.right);
    }
}
