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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) { //基本思路，从target出发分别向上和向下找
        if (K == 0) return Collections.singletonList(target.val);
        Map<TreeNode, TreeNode> map = new HashMap<>(); //保存子-母 图，方便向上找
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == target) break; //不记录target同层及以下的子树，因为一会要向下找，上面的会通过map回去，然后在left，right向下找
            if (cur.left != null) {
                map.put(cur.left, cur);
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }
        queue.clear();
        queue.offer(target);
        visited.add(target);
        List<Integer> res = new ArrayList<>(); 
        
        while (K > 0) {
            if (queue.isEmpty()) return res;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null && visited.add(cur.left)) queue.offer(cur.left); //左右两边
                if (cur.right != null && visited.add(cur.right)) queue.offer(cur.right);
                if (map.get(cur) != null && visited.add(map.get(cur))) queue.offer(map.get(cur)); //向上
            }
            K--;
        }
        while (!queue.isEmpty()) res.add(queue.poll().val);
        return res;
    }
}
