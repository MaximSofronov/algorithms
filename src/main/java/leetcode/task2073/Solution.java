package leetcode.task2073;

class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            time += tickets[k];

            if (tickets[i] < tickets[k]) {
                time -= tickets[k] - tickets[i] - 1;
                if (i < k) {
                    time--;
                }
            }

            if (i > k) {
                time--;
            }
        }

        return time;
    }
}