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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) map.put(post[i], i); //储存post因为pre是一个根接着一个，post找到根即可确定这一层的范围
        return buildTree(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }
    
    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] post, 
                               int postStart, int postEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]); //build current tree
        if (preStart != preEnd) { //如果只有一个了说明到头了
            int scope = map.get(pre[preStart + 1]) - postStart; //比如找到下一层左节点2，-4=2就是这一层的范围
            root.left = buildTree(pre, preStart + 1, preStart + 1 + scope, post, postStart, postStart + scope, map);
            //                         移到下一个     加上范围                    不变        范围相同
            root.right = buildTree(pre, preStart + 1 + scope + 1, preEnd, post, postStart + scope + 1, postEnd - 1, map);
            //                          基于上边的+1               不变           上面的+1              注意post最后一个是根用过了-1
        }
        return root;
    }
}
//related 105 106
