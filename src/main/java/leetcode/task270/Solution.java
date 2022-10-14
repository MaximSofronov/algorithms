package leetcode.task270;

public class Solution {

    public int closestValue(TreeNode root, double target) {
        int currentBest = root.val;
        while (root != null) {
            if (difference(root.val, target) < difference(currentBest, target)) {
                currentBest = root.val;
            }
            if (difference(currentBest, target) == 0) {
                return currentBest;
            }
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return currentBest;
    }

    private double difference(Number a, Number b) {
        return Math.abs(a.doubleValue() - b.doubleValue());
    }
}