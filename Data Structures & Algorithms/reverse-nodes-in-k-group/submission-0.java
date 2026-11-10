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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode main = dummy;
        ListNode current = head;
        ListNode end = head;

        while (current != null) {
            int segmentLength = 0;
            ListNode counterPointer = current;
            while(counterPointer != null){
                counterPointer = counterPointer.next;
                segmentLength++;
            }
            if(segmentLength < k) {
                main.next = current;
                break;
            }
            end = current;
            ListNode held = null;
            ListNode prev = null;
            int counter = 0;

            while (counter < k) {
                held = current.next;
                current.next = prev;
                prev = current;
                current = held;
                counter++;
            }

            main.next = prev;
            main = end;
        }

        return dummy.next;
    }
}
