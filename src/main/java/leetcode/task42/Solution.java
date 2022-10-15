package leetcode.task42;

public class Solution {

    public int trap(int[] heights) {

        if (heights.length <= 2) {
            return 0;
        }

        int res = 0;

        int[] maxFromLeft = new int[heights.length];

        int currentMaxFromLeft = heights[0];
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > currentMaxFromLeft) {
                currentMaxFromLeft = heights[i];
            }
            maxFromLeft[i] = currentMaxFromLeft;
        }

        int currentMaxFromRight = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > currentMaxFromRight) {
                currentMaxFromRight = heights[i];
            }

            res += Math.min(maxFromLeft[i], currentMaxFromRight) - heights[i];
        }

        return res;
    }
}
