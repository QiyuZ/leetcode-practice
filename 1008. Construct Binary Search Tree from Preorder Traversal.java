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
    private int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }
    private TreeNode build(int[] nums, int bound) {
        if (i == nums.length || nums[i] > bound) return null; //到头或者越界不成立null
        TreeNode cur = new TreeNode(nums[i++]);
        cur.left = build(nums, cur.val); //因为preorder所以下一个默认是left，当然不能越界，更新max为root.val
        cur.right = build(nums, bound); //对于右子树，边界还是本次边界
        return cur;
    }
}
