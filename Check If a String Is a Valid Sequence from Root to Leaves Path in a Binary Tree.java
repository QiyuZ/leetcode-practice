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
class Solution {  //bfs
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (arr == null || arr.length == 0) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty() && i < arr.length) {
            int size = queue.size();
            boolean found = false;
            for (int count = 0; count < size; count++) {
                TreeNode cur = queue.poll();
                if (cur.val == arr[i]) {
                    if (i == arr.length - 1 && cur.left == null && cur.right == null) return true;
                    found = true;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
            }
            if (found) i++;
        }
        return false;
    }
}


class Solution {  //dfs
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return checkPath(root, arr, 0);
    }
     private static boolean checkPath(TreeNode root, int arr[], int index) {
         if (root == null || index >= arr.length) return false;
         if(root.left == null && root.right == null && root.val == arr[index] && index == arr.length - 1) {
             return true;
         }
         return root.val == arr[index] && 
             (checkPath(root.left, arr, index + 1) || checkPath(root.right, arr, index + 1));
   
    }
}
