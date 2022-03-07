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
    int count;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode node) {
        if (node.left != null) helper(node.left);
        count--;
        if (count == 0) {
            res = node.val;
            return;
        }
        if (node.right != null) helper(node.right);
    }
}


class Solution {
    private TreeNode getPred(TreeNode current, TreeNode target){ //eg. [3,1,4,null,2] connect 2->3 find node 3 's real previous node, so it's kind like iterate from left to right
        while(current.right != null && current.right != target) current = current.right;
        return current;
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        int count = 0;
        while(current != null){
            if(current.left == null){
                count++;
                if(count == k) return current.val;
                current = current.right; 
            }
            else{
                TreeNode pred = getPred(current.left, current);
                if(pred.right == null){ //hasn't connect before, connect and move left
                    pred.right = current;
                    current = current.left;
                } else{
                    pred.right = null; //connect before then disconnect, same example, when visit 3 again it's connected
                    count++;
                    if(count == k) return current.val;
                    current = current.right;
                }
            }
        }
        return -1;
    }
}
