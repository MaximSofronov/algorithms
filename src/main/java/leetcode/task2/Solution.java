package leetcode.task2;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode resultCurrent = result;

        int toAddToNextDigit = 0;

        while (l1 != null || l2 != null) {
            int currentDigitsSum = 0;
            if (l1 != null) {
                currentDigitsSum += l1.val;
            }
            if (l2 != null) {
                currentDigitsSum += l2.val;
            }
            currentDigitsSum += toAddToNextDigit;
            toAddToNextDigit = 0;

            if (currentDigitsSum >= 10) {
                int remainder = currentDigitsSum % 10;
                toAddToNextDigit = currentDigitsSum / 10;

                resultCurrent.next = new ListNode(remainder);
            } else {
                resultCurrent.next = new ListNode(currentDigitsSum);
            }
            resultCurrent = resultCurrent.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (toAddToNextDigit > 0) {
            resultCurrent.next = new ListNode(toAddToNextDigit);
        }

        return result.next;
    }
}
