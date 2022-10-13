package geeksforgeeks.floorandceilfromabst;

public class Solution {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(8,
                new TreeNode(4, new TreeNode(2), new TreeNode(6)),
                new TreeNode(12, new TreeNode(10), new TreeNode(14)));
//        TreeNode tree = new TreeNode(8,
//                new TreeNode(4, new TreeNode(2), null),
//                new TreeNode(12, null, new TreeNode(14)));

        int[] keys = new int[]{11, 1, 3, 6, 5, 15};
        for (int key : keys) {
            System.out.printf("Key: %s, Floor: %s, Ceil: %s%n", key, floor(tree, key), ceil(tree, key));
        }
    }

    public static int floor(TreeNode node, int input) {
        return getFloor(node, input, Integer.MIN_VALUE, true);
    }

    public static int ceil(TreeNode node, int input) {
        return getCeil(node, input, Integer.MAX_VALUE, true);
    }

    private static int getFloor(TreeNode node, int input, int parentValue, boolean onlyLeft) {
        if (node.val > input) {
            if (node.left != null) {
                return getFloor(node.left, input, node.val, onlyLeft);
            }
            return onlyLeft ? -1 : parentValue;
        }
        if (node.val < input && node.right != null) {
            return getFloor(node.right, input, node.val, false);
        }

        return node.val;
    }

    private static int getCeil(TreeNode node, int input, int parentValue, boolean onlyRight) {
        if (node.val < input) {
            if (node.right != null) {
                return getCeil(node.right, input, node.val, onlyRight);
            }
            return onlyRight ? -1 : parentValue;
        }
        if (node.val > input && node.left != null) {
            return getCeil(node.left, input, node.val, false);
        }

        return node.val;
    }
}
