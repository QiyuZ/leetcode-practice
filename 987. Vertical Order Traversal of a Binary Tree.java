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
    public List<List<Integer>> verticalTraversal(TreeNode root) { //刚开始只表达了x发现顺序不对，所以加上y也就是深度，都按照大小排序
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>(); //用list原因是可能位置坐标重复，比如第三层，第二层左子树的右节点和右子树的左节点
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (int x : map.keySet()) {
            List<Integer> cur = new ArrayList<>();
            for (int y : map.get(x).keySet()) {
                List<Integer> values = map.get(x).get(y);
                Collections.sort(values);
                for (int i = 0; i < values.size(); i++) cur.add(values.get(i));
            }
            list.add(cur);
        }
        return list;
    }
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) return;
        if (!map.containsKey(x)) map.put(x, new TreeMap<>());
        if (!map.get(x).containsKey(y)) map.get(x).put(y, new ArrayList<>());
        map.get(x).get(y).add(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}
