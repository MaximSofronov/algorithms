package leetcode.task236;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.left != null) {
            if (containsNodesAsChildren(root.left, p, q)) {
                return lowestCommonAncestor(root.left, p, q);
            }
        }

        if (root.right != null) {
            if (containsNodesAsChildren(root.right, p, q)) {
                return lowestCommonAncestor(root.right, p, q);
            }
        }

        return root;
    }

    private boolean containsNodesAsChildren(TreeNode root, TreeNode p, TreeNode q) {
        return containsNodeAsChildren(root, p) && containsNodeAsChildren(root, q);
    }

    private boolean containsNodeAsChildren(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }

        if (root.val == node.val) {
            return true;
        }

        return containsNodeAsChildren(root.left, node) || containsNodeAsChildren(root.right, node);
    }
}
