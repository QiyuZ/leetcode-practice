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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        getPathSum(res, new ArrayList<>(), root, sum, 0);
        return res;
    }
    private void getPathSum(List<List<Integer>> res, List<Integer> temp, TreeNode root, int sum, int cur) {
        if (root == null) return;
        if (root.left == null && root.right == null && cur + root.val == sum) {
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1); //注意此处也要remove否则上次的最后一个会留在这里，或者line 34,35 重新new ArrayList
            //如果你问为什么别的recursive这里不用remove,eg. leetcode 17. 因为别的只有一行recursive, return后就直接remove了，此处line 34,35都要，这样如果发生在34行就不会被remove了, 因为此处是直接return所以只有一次remove会被触发，或者使用下面更generic方法，先add再判断，一定remove
            return;
        }
        int size = temp.size();
        temp.add(root.val);
        getPathSum(res, temp, root.left, sum, cur + root.val);
        getPathSum(res, temp, root.right, sum, cur + root.val);
        temp.remove(size);
    }
}


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) { 
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, result, list);
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, List<List<Integer>> result , List<Integer> list) {
         if(root == null) return; 
         list.add(root.val);   
         if(sum == root.val && root.left == null && root.right == null) result.add(new ArrayList<>(list));
         else{
            pathSum(root.left, sum - root.val, result, list); 
            pathSum(root.right, sum - root.val, result, list);  
         }
         list.remove(list.size() - 1); 
    }
}
