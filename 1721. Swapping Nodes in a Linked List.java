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
class Solution { //when reach to k, start a new iteration from begining, then when end, the second on stops at n - k
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, first = null, second = null;
        int count = k;
        while (cur != null) {
            count--;
            if (second != null) second = second.next; //do this before next assigning block, otherwise it will take etra move at that round
            if (count == 0) {
                first = cur;
                second = head;
            }
            cur = cur.next;
        }
        int tmp = second.val;
        second.val = first.val;
        first.val = tmp;
        return head;
    }
}
