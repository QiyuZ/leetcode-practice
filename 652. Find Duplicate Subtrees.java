class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return res;
        helper(root);
        return res;
    }
    public String helper(TreeNode node) {
        if (node == null) return "*";
        String left = helper(node.left), right = helper(node.right);
        String key = node.val + left + right;
        map.put(key,map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) res.add(node);
        return key;
    }
}
