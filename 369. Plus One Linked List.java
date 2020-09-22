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
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode copy = dummy, lastNotNine = null; //找出最后一个非9的位置，然后当前+1，后面如果有9都变成0，如果没有则无所谓前面不用管，因为不会进位， 如199找1， 1293找3，123找3
        while (copy != null) {
            if (copy.val != 9) lastNotNine = copy;
            copy = copy.next;
        }
        lastNotNine.val += 1;
        lastNotNine = lastNotNine.next;
        while (lastNotNine != null && lastNotNine.val == 9) {
            lastNotNine.val = 0;
            lastNotNine = lastNotNine.next;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
}
