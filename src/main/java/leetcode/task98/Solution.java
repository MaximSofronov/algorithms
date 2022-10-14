package leetcode.task98;

import java.util.LinkedList;

class Solution {
    public boolean isValidBST(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();

        return validateBST(root, list);
    }

    private boolean validateBST(TreeNode node, LinkedList<Integer> list) {
        if (node == null) {
            return true;
        }

        if (!validateBST(node.left, list)) {
            return false;
        }
        if (!list.isEmpty() && list.getLast() >= node.val) {
            return false;
        }
        list.add(node.val);
        return validateBST(node.right, list);
    }
}
