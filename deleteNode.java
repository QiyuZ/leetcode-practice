/*Binary Tree 删除其中的一些节点，返回所有剩下子树。
例如             B                                            B
                / \                                             \
              A   C              删除 A，G                        C
             / \    \            =======》             
           k   F     G                                  K  F        G
          / \         \                                / \            \
         Z   X         M                               Z  X            M
*/

class Solution {
  public List<TreeNode> deleteNode(TreeNode root, Set<TreeNode> deleted) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<TreeNode> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur == null) continue;
      helper(cur, deleted, null, queue, true);
      res.add(cur);
    }
    return res;
  }
  public void helper (TreeNode root, Set<TreeNode> deleted, TreeNode father, Queue<TreeNode> queue, boolean left ) {
    if (root == null) return;
    if (deleted.contains(root)) {
      if (father != null) {
        if (left) father.left = null;
        else father.right = null;
      }
      queue.offer(root.left);
      queue.offer(root.right);
    }
    helper(root.left, deleted, root, queue, true);
    helper(root.right, deleted, root, queue, false);
  }
}
