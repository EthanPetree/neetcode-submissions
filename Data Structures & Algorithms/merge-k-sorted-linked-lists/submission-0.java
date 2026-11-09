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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1)
            return null;
        ListNode[] mergedList;

        do {
            mergedList = new ListNode[(lists.length + 1) / 2];
            int counter = 0;
            for (int i = 0; i < lists.length; i += 2) {
                if (i + 1 >= lists.length) {
                    mergedList[counter] = lists[i];
                    continue;
                }
                ListNode a = lists[i], b = lists[i + 1];
                ListNode dummy = new ListNode(-1);
                ListNode current = dummy;
                while (a != null && b != null) {
                    if (a.val <= b.val) {
                        current.next = a;
                        a = a.next;
                        current = current.next;
                        current.next = null;
                    } else {
                        current.next = b;
                        b = b.next;
                        current = current.next;
                        current.next = null;
                    }
                }

                if(a != null){
                    current.next = a;
                } else if (b != null){
                    current.next = b;
                }

                mergedList[counter++] = dummy.next;
            }

            lists = mergedList;
        } while (mergedList.length > 1);

        return mergedList[0];
    }
}
