/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode root = head, next = null;
        while (root != null) { //step1 copy the normal list
            next = root.next;
            RandomListNode copy = new RandomListNode(root.label);
            root.next = copy;
            copy.next = next;
            root = next;
        }
        root = head;
        while (root != null) { //step2: connect the random
            if (root.random != null) root.next.random = root.random.next;
            root = root.next.next;
        }
        root = head;
        RandomListNode res = new RandomListNode(0);
        RandomListNode copyNext = null, copy = res;
        while (root != null) { //分开
            next = root.next.next;
            copyNext = root.next;
            copy.next = copyNext;
            copy = copy.next; //更新位置，继续走
            root.next = next; //不破坏原链表
            root = next;
        }
        return res.next;
    }
}
