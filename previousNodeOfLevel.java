//给一棵树（不一定是二叉树）和一个节点（保证存在），按层次遍历顺序查询该节点的上一个节点，每层第一个节点的上一个节点规定为NULL。
class Solution {
	public TreeNode previousNodeOfLevel(TreeNode root, TreeNode target) {
		Queue<TreeNode> queue = new LinkedList<>();
		//Map<TreeNode, TreeNode> map = new HashMap<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode pre = null;
			int n = queue.size();
			while (n-- > 0) {
				TreeNode cur = queue.pop();
				if (cur == t) return pre;
				map.put(cur, pre);
				pre = cur;
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			}
		}
		return null;
		//return map.get(target);
	}
}
//优化可以用map储存多次调用，即注释
