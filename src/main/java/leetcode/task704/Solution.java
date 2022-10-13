package leetcode.task704;

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int midIndex = (left + right) / 2;
        int midValue = nums[midIndex];
        if (midValue == target) {
            return midIndex;
        } else if (midIndex == left && midIndex == right) {
            return -1;
        }
        if (midValue < target) {
            return binarySearch(nums, midIndex + 1, right, target);
        }
        return binarySearch(nums, left, midIndex - 1, target);
    }
}
