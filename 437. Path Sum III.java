
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        map.put(0, 1);//Default sum = 0 has one count
        return helper(root, sum, 0);
    }
    public int helper(TreeNode node, int target, int cur) {
        if (node == null) return 0;
        cur += node.val;
        int res = map.getOrDefault(cur - target, 0);//See if there is a subarray sum equals to target
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        res += helper(node.left, target, cur) + helper(node.right, target, cur);
        map.put(cur, map.get(cur) - 1);//Remove the current node so it wont affect other path, 因为只能往下选一边，如果不remove会左右子树都选上
        return res;
    }
}


class Solution {
    private int count = 0; //count要global否则recursive back后一直是0
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        getPathSum(map, root, sum, 0);
        return count;
    }
    
    private void getPathSum(Map<Integer, Integer> map, TreeNode root, int sum, int cur) {
        if (root == null) return;
        if (map.containsKey(cur + root.val - sum)) count += map.get(cur + root.val - sum);
        map.put(cur + root.val, map.getOrDefault(cur + root.val, 0) + 1); //这一步要在line 28后面因为可能算上自己，比如root = [1], sum =  0
        getPathSum(map, root.left, sum, cur + root.val);
        getPathSum(map, root.right, sum, cur + root.val);
        if (map.get(cur + root.val) == 1) map.remove(cur + root.val);
        else map.put(cur + root.val, map.get(cur + root.val) - 1);
    }
}


public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
