class Solution {
    public int countNodes(TreeNode root) { //暴力一个个找，会超时，利用完全二叉树性质
        if (root == null) return 0;
        int l = countLeft(root) + 1;
        int r = countRight(root) + 1;
        if (l == r) return (1 << l) - 1; //因为完全二叉树向左对齐所以如果左右深度相同则是满二叉树直接计算，减去重复计算的根节点
        else return countNodes(root.left) + countNodes(root.right) + 1; //不相等说明有一个不满，则往下递归，别忘了加上最后的根节点
    }
    public int countLeft(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }
    public int countRight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            root = root.right;
            count++;
        }
        return count;
    }
}
