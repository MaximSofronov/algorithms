package leetcode.task75;

class Solution {

    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }

        int currentIndex = 0;
        for (int color = 0; color < colors.length; color++) {
            int count = colors[color];
            for (int i = 0; i < count; i++) {
                nums[currentIndex++] = color;
            }
        }
    }
}
