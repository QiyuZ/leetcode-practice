/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1 每次遍历数组找第一个小的和第一个大作为上下限 O(n^2)
//Solution2 因为是前序遍历bst所以相当于是个rotate sorted array, 可以用binary search来找到分界点，比如例子中[8,5,1,7,10,12] 从5,1,7,10,12找8，即7的位置左边是left右边right
    // def bstFromPreorder(self, A):
    //     def helper(i, j):
    //         if i == j: return None
    //         root = TreeNode(A[i])
    //         mid = bisect.bisect(A, A[i], i + 1, j)
    //         root.left = helper(i + 1, mid)
    //         root.right = helper(mid, j)
    //         return root
    //     return helper(0, len(A))
//Solution3 既然是preorder那么按照前序的顺序来走，带着上下限，这样知道应该什么时候停止
class Solution {
    private int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildTree(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private TreeNode buildTree(int[] preorder, int upbound, int lowbound) {
        if (i == preorder.length || preorder[i] >= upbound || preorder[i] <= lowbound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = buildTree(preorder, root.val, lowbound);
        root.right = buildTree(preorder, upbound, root.val);
        return root;
    }
}
