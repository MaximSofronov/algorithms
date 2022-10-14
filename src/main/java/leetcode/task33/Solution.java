package leetcode.task33;

class Solution {

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int midIndex = (left + right) / 2;
        int decrementedMidIndex = Math.max(midIndex - 1, left);
        int incrementedMidIndex = Math.min(midIndex + 1, right);
        int midValue = nums[midIndex];
        if (midValue == target) {
            return midIndex;
        } else if (midIndex == left && midIndex == right) {
            return -1;
        }

        boolean shiftOnTheRight = doesContainShift(nums, incrementedMidIndex, right);
        boolean shiftOnTheLeft = doesContainShift(nums, left, decrementedMidIndex);

        boolean doesValueOnTheLeftIfLeftIsNotShifted = doesValueInsideNotShiftedArray(nums, left, decrementedMidIndex, target);
        boolean doesValueOnTheRightIfRightIsNotShifted = doesValueInsideNotShiftedArray(nums, incrementedMidIndex, right, target);

        if (midValue < target) {
            // 1. if: shift on the RIGHT
            if (shiftOnTheRight) {
                // 1.1. if: target on the LEFT
                if (doesValueOnTheLeftIfLeftIsNotShifted) {
                    return binarySearch(nums, left, decrementedMidIndex, target);
                } else { // 1.2. else: target on the RIGHT
                    return binarySearch(nums, incrementedMidIndex, right, target);
                }
            }
            // 2. else if: shift on the LEFT
            else if (shiftOnTheLeft) {
                // 2.1. if: target on the RIGHT
                if (doesValueOnTheRightIfRightIsNotShifted) {
                    return binarySearch(nums, incrementedMidIndex, right, target);
                } else { // 2.2. else: target on the LEFT
                    return binarySearch(nums, left, decrementedMidIndex, target);
                }
            }
            // 3. else: no shift in new arrays
            else {
                // 3.1. if: value on the LEFT
                if (doesValueOnTheLeftIfLeftIsNotShifted) {
                    return binarySearch(nums, left, decrementedMidIndex, target);
                }
                // 3.2. else: value on the RIGHT
                else {
                    return binarySearch(nums, incrementedMidIndex, right, target);
                }
            }
        }
        // 1. shift on the LEFT
        if (shiftOnTheLeft) {
            // 1.1. target on the RIGHT
            if (doesValueOnTheRightIfRightIsNotShifted) {
                return binarySearch(nums, incrementedMidIndex, right, target);
            } else { // 1.2. target on the LEFT
                return binarySearch(nums, left, decrementedMidIndex, target);
            }
            // 2. else if: shift on the RIGHT
        } else if (shiftOnTheRight) {
            // 2.1. target on the LEFT
            if (doesValueOnTheLeftIfLeftIsNotShifted) {
                return binarySearch(nums, left, decrementedMidIndex, target);
            } else { // 2.2. target on the RIGHT
                return binarySearch(nums, incrementedMidIndex, right, target);
            }
            // 3. else: no shift in new arrays
        } else {
            // 3.1. if: value on the LEFT
            if (doesValueOnTheLeftIfLeftIsNotShifted) {
                return binarySearch(nums, left, decrementedMidIndex, target);
            }
            // 3.2. else: value on the RIGHT
            else {
                return binarySearch(nums, incrementedMidIndex, right, target);
            }
        }
    }

    private boolean doesContainShift(int[] nums, int left, int right) {
        return nums[left] >= nums[right];
    }

    private boolean doesValueInsideNotShiftedArray(int[] nums, int left, int right, int val) {
        return nums[left] <= val && val <= nums[right];
    }
}
