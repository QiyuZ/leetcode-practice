/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //121, slow应该走到1，这样如果是奇数后面比较时忽略最后一个单个的，不影响 ； 1221 slow应该走到第二个2
        if (fast != null) slow = slow.next;
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode node) {
        ListNode newNode = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = newNode;
            newNode = node;
            node = next;
        }
        return newNode;
    }
}
