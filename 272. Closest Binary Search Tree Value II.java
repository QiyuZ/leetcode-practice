//整体思路为按照中序遍历则为从小到大排序，遇到合适的放进去并移除第一个
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        helper(root, target, k, res);
        return res;
    }
    public void helper(TreeNode root, double target, int k, List<Integer> res) {
        if (root == null) return;
        helper(root.left, target, k, res);
        if (res.size() < k) res.add(root.val);
        else {
            if (Math.abs(target - root.val) < Math.abs(target - res.get(0))) {
                res.remove(0);
                res.add(root.val);
            } else return; //有了这个会快一些因为会移除一些不必要的右分支，因为既然当前节点已经不满足就不用找更大了的
        }
        helper(root.right, target, k, res);
    }
}
