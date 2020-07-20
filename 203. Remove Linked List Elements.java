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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode copy = new ListNode(0);
        copy.next = head;
        head = copy;
        while (copy != null) {
            ListNode next = copy.next;
            if (next != null && next.val == val) copy.next = next.next;
            else copy = copy.next;
        }
        return head.next;
    }
}
