/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) { //不用找出全部的数字，分治，携带当前sum
        if (root == null) return 0;
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int pre) {//parent node可能被加多次，一次传递前一次的值就行
        if (root == null) return 0;//这里是0，因为此处没有数字形不成数比如1,0 只是10，没有单独的1
        if (root.left == null && root.right == null) return pre * 10 + root.val; //最后一层
        return helper(root.left, pre * 10 + root.val) + helper(root.right, pre * 10 + root.val); //分治
    }
    
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumR(root, 0);
    }
    
    public int sumR(TreeNode root, int x) {
        if (root.right == null && root.left == null) return 10 * x + root.val;
        int val = 0;
        if (root.left != null) val += sumR(root.left, 10 * x + root.val);
        if (root.right != null) val += sumR(root.right, 10 * x + root.val);
        return val;
    }
}
