/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>(); //每次都push index，push前检查当前的是否大于stack里的数字
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) res[stack.pop()] = list.get(i); //用while，当前数，检查所有满足都是
            stack.push(i);
        }
        return res;
    }
}
