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
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) { //find the start of second part 1-2-3-4-5
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, cur = slow;
        while (cur != null) {  //reverse the second part 1-2-5-4-3
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode first = head, second = pre; //mark head of part 1 and part 2
        while (second.next != null) { //alternately append one by one 1-5-2-4-3
            ListNode next = first.next;
            first.next = second;
            first = next;
            next = second.next;
            second.next = first;
            second = next;
        }
    }
}
