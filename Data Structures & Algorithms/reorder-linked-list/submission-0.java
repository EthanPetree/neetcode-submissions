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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalfHead = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode current = secondHalfHead;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode halfPointer = prev;
        current = head;
        while (halfPointer != null) {
            ListNode cTemp = current.next;
            current.next = halfPointer;
            ListNode hTemp = halfPointer.next;
            halfPointer.next = cTemp;

            halfPointer = hTemp;
            current = cTemp;
        }
    }
}
