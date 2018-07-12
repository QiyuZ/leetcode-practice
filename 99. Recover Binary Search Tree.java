/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Morris遍历,不符合前面小于后面的，第一次遇到的取前面，第二次遇到的取后面
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, pre = new TreeNode(Integer.MIN_VALUE);
        boolean firstElement = true;
        while (root != null) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null && temp.right != root) temp = temp.right; //尽量走到子树的右节点
                if (temp.right == null) { //走不动了如果是null说明第一次走到此处，建桥连接root, root可以左移了
                    temp.right = root;
                    root = root.left;
                } else { //说明再一次走到此处，即已经建桥temp.right = root，这个时候可以取消这个连接,说明当前右边走不动了，visit
                    temp.right = null;
                    //visit root.val 每次换root前都要visit
                    if (pre.val > root.val && firstElement) {//不符合前面小于后面的，第一次遇到的取前面
                        first = pre;
                        firstElement = false;
                    }
                    if (pre.val > root.val && !firstElement) second = root;  //第二次遇到的取后面
                    pre = root;  //pre和root都要接着走
                    root = root.right;
                }
            } else { //左边走不动了，说明到了最左边，visit
                //visit root.val
                if (pre.val >= root.val && firstElement) {
                        first = pre;
                        firstElement = false;
                    }
                if (pre.val >= root.val && !firstElement) second = root;
                pre = root;
                root = root.right;
            }
        }
        if (first != null && second != null) { //交换
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}



//空间为n的
public class Solution {
    
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    private void traverse(TreeNode root) {
        if (root == null) return;  
        traverse(root.left);
        // Start of "do some business", 
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) firstElement = prevElement;
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) secondElement = root;
        prevElement = root;
        // End of "do some business"
        traverse(root.right);
}
