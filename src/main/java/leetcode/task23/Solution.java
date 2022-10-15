package leetcode.task23;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode resultLast = result;

        int currentLowestValue;

        boolean listsOvered = false;

        while (!listsOvered) {
            currentLowestValue = Integer.MAX_VALUE;

            listsOvered = true;
            for (ListNode listNode : lists) {
                if (listNode == null) {
                    continue;
                } else {
                    listsOvered = false;
                }

                if (listNode.val < currentLowestValue) {
                    currentLowestValue = listNode.val;
                }
            }

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (lists[i].val == currentLowestValue) {
                    resultLast.next = new ListNode(currentLowestValue);
                    resultLast = resultLast.next;
                    lists[i] = lists[i].next;
                }
            }
        }

        return result.next;
    }
}
