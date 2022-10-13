package leetcode.task108;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateBST(nums);
    }

    private TreeNode generateBST(int[] currentArray) {
        if (currentArray.length == 0) {
            return null;
        }
        if (currentArray.length == 1) {
            return new TreeNode(currentArray[0]);
        }
        if (currentArray.length == 2) {
            return new TreeNode(currentArray[1], new TreeNode(currentArray[0]), null);
        }

        int middleIndex = currentArray.length / 2;

        int[] left = new int[middleIndex];
        int[] right = new int[currentArray.length - currentArray.length / 2 - 1];
        System.arraycopy(currentArray, 0, left, 0, left.length);
        System.arraycopy(currentArray, middleIndex + 1, right, 0, right.length);
        return new TreeNode(currentArray[middleIndex], generateBST(left), generateBST(right));
    }
}
