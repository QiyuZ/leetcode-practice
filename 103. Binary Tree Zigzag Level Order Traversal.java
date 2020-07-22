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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean leftRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {  //BFS, leftRight记录方向
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (leftRight) tmp.add(cur.val);
                else tmp.add(0, cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(tmp);
            leftRight = !leftRight;
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        explore(root, 0, result);
        return result;
    }
    public void explore(TreeNode root, int level, List<List<Integer>> result){
        if(root==null) return;
        if(result.size()==level) result.add(new ArrayList<Integer>());
        if(level%2==0) result.get(level).add(root.val);
        else result.get(level).add(0, root.val);
        explore(root.left, level+1, result);
        explore(root.right, level+1, result);
    }
}
