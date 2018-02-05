class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) res = root.val;
            root = root.val > target ? root.left :root.right;
        }
        return res;
    }
}

class Solution {
    public class Solution {
        public int closestValue(TreeNode root, double target) {
            int a = root.val;
            if (a == target) return a;
            TreeNode kid = a < target ? root.right : root.left;
            if (kid == null) return a;
            int b = closestValue(kid, target);
            return Math.abs(a - target) < Math.abs(b - target) ? a : b; //相当于一直两两比较下去
        }
    }
}
