/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //same as 863三个方向左右上
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>(); //child - parent
        TreeNode target = dfs(root, k, map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<Integer> visited = new HashSet<>();
        visited.add(k);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) return cur.val;
            if (cur.left != null && visited.add(cur.left.val)) queue.offer(cur.left);
            if (cur.right != null && visited.add(cur.right.val)) queue.offer(cur.right);
            if (map.get(cur) != null && visited.add(map.get(cur).val)) queue.offer(map.get(cur)); //避免先下后上的重复
        }
        return -1;
    }
    
    private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root.val == k) return root;
        if (root.left != null) {
            map.put(root.left, root);
            TreeNode left = dfs(root.left, k, map);
            if (left != null) return left;
        }
        if (root.right != null) {
            map.put(root.right, root);
            TreeNode right = dfs(root.right, k, map);
            if (right != null) return right;
        }
        return null;
    }
}
