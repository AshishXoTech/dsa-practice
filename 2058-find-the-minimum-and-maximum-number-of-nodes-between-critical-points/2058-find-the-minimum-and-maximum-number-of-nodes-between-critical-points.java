/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};
        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        int first = -1;
        int prevCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;
        while (curr.next != null) {
            int prevVal = prev.val;
            int currVal = curr.val;
            int nextVal = curr.next.val;
            boolean isCritical =
                    (currVal > prevVal && currVal > nextVal) ||
                    (currVal < prevVal && currVal < nextVal);
            if (isCritical) {
                if (first == -1) {
                    first = index;
                } else {   
                    minDistance = Math.min(
                        minDistance,
                        index - prevCritical
                    );
                }
                prevCritical = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        if (first == -1 || first == prevCritical) {
            return ans;
        }
        maxDistance = prevCritical - first;
        return new int[]{minDistance, maxDistance};
    }
}