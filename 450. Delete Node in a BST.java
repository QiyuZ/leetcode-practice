class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        else if (root.val > key) root.left = deleteNode(root.left, key); //注意不直接return的一定要用else
        else if (root.val < key) root.right = deleteNode(root.right, key);//不能直接return否则返回的是子树，要接着递归把子树的target key去掉
        else {                                                           //否则此处，会被多执行一次
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            TreeNode temp = root.right;
            while (temp.left != null) temp = temp.left;
            int newVal = temp.val; 
            //如何删除？由于不知道parent node，所以最佳办法是把当前val替换成左最大或者右最小，然后再删除那个左最大或者右最小，依次递归
            root.val = newVal;
            root.right = deleteNode(root.right, newVal);
        }
        return root;
    }
}
