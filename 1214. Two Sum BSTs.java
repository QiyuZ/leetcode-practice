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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) return false;
        if (root1.val + root2.val == target) return true;
        else if (root1.val + root2.val > target) return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
        return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
    }
}

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null) return false;
        Set<Integer> set = new HashSet();
        add(root1, set);
        return find(root2, set, target);
    }
    
    private boolean add(TreeNode root, Set<Integer> set, int target) {
        if(root == null) return false;
        set.add(root.val);
        add(root.left, set);
        add(root.right, set);
    }
    
    private boolean find(TreeNode root, Set<Integer> set, int target) {
        if(root == null) return false;
        if(set.contains(target - root.val)) return true;
        return find(root.left, set, target) || find(root.right, set, target);
    }
}
