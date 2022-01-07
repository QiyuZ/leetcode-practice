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
    private ListNode head;
    private Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head, res = head;
        int size = 1;
        while (cur != null) {
            if ((size - 1) == rand.nextInt(size)) res = cur;
            size++;
            cur = cur.next;
        }
        return res.val;
    }
}

//当长度可测时，可以先选出len随机数在里面选取
//当长度不可测时，蓄水池抽样的方法。 先让选第一个val, 而后第二次以1/2概率选第二个 ，第三个有1/3概率，每个其实都是相等概率比如第一个就是有1*(1/2)*(2/3)=1/3
//某元素下标为a，那么它最后被选中的概率是：(遍历到该元素时，选中该元素的概率)*(其后所有元素都没被选中的概率)

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
