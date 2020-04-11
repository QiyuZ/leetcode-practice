/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode root = head;
        while (root.next != null) {
            count++;
            root = root.next;
        }
        count = (count + 1) / 2;
        while (count-- > 0) head = head.next;
        return head;
    }
}


class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) slow = slow.next; //说明两个middle,取后面的
        return slow;
    }
}
