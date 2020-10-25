/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean hasEncounteredNullValue = false;
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current == null) hasEncounteredNullValue = true;
            else if (hasEncounteredNullValue) return false; //只有最后一个是null是才不会遇到这个，因为已经空了，中间有一个null而且不空就会false
            else {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }
}


class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) break; //如果是CompleteTree，那么只有最后一个才是null,否则break后queue还有tree说明null在中间即不满足
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) queue.poll();//注意此处后面可能有多个null要全poll出后看有没有valid node在后面
        return queue.isEmpty();
    }
}
