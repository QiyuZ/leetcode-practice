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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        getLeaves(root1, sb1);
        getLeaves(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }
    
    private void getLeaves(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) sb.append(root.val);
        getLeaves(root.left, sb);
        getLeaves(root.right, sb);
    }
}

	 public boolean leafSimilar(TreeNode root1, TreeNode root2) { 
		 return traverse(root1).equals(traverse(root2));
     }
	 String traverse(TreeNode root){
		 if(root==null) return "";
		 if(root.left==null && root.right==null) return root.val+"-";  
		 return traverse(root.left)+traverse(root.right);
     }
