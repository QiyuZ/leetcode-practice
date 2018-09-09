/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) { //不是null就加数字
                    res.append(cur.val + " ");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else res.append("null ");//或者加null
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] values = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0])); //初始root也是最后结果
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode cur = queue.poll();
            if (!values[i].equals("null")) { //和上面顺序一样，先左后右
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                cur.left = left;
                queue.offer(left);//要放入queue为了后面的操作
            }
            i++; //别忘了移动index
            if (!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                cur.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
