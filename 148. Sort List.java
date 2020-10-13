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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;//记录slow前一个节点
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //切断中间，head和slow的连接处
        ListNode left = sortList(head), right = sortList(slow);
        return mergeListNode(left, right);
    }
    
    private ListNode mergeListNode(ListNode left, ListNode right) {
        if (left == null && right == null) return null;
        if (left == null || right == null) return left == null ? right : left;
        if (left.val < right.val) {
            left.next = mergeListNode(left.next, right);
            return left;
        }
        right.next = mergeListNode(left, right.next);
        return right;
    }
}
