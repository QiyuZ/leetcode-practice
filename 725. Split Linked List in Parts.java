/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode move = root;
        while (move != null) {
            size++;
            move = move.next;
        }
        int baseSize = size / k;
        int extraSize = size % k;
        ListNode[] res = new ListNode[k];
        move = root;
        int index = 0;
        while (move != null) {
            int curSize = baseSize + (extraSize-- > 0 ? 1 : 0);
            res[index++] = move; //pointer located at header and will not change  
            while (move != null && --curSize > 0) {
                move = move.next;
            }
            ListNode next = move.next;
            move.next = null;
            move = next;
        }
        return res;
    }
}
