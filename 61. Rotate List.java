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
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode copy = head;
        int len = 1;
        while (copy.next != null) {
            len++;
            copy = copy.next;
        }
        copy.next = head; //connect tail with head
        for (int i = 0; i < len - k % len; i++) copy = copy.next; //move to the new tail
        ListNode res = copy.next; //find new head
        copy.next = null; //disconnect new tail and head
        return res;
    }
}
